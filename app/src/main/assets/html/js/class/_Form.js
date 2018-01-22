function Form(iObjHTML)
{
	var _Config 	= new Config();

    var _Type       = "a1";

	var _User 		= "2";

	var _ListView 	= _Config.VIEWLIST.form;
	var _ObjHTML 	= iObjHTML == undefined ? {} : iObjHTML;

	var _Self 		= this;

    var _Score      = {
        keberadaan  : 0,
        lokasi      : 0,
        kondisi     : 0,
        fungsi      : 0,
        total       : 0.00
    };
	var _DetScore	= [];
	var _Foto       = [];

    var _Questionnaire  = null;

	this.JSISetGPS 		= function(iLat, iLong)
	{
		_ObjHTML.divheader.find("#lat").val(iLat);
		_ObjHTML.divheader.find("#long").val(iLong);
	}

	this.JSIAddPhoto 	= function(iSrcImg, iNamaImg)
	{
		_ListView.image.find("img").attr("src", iSrcImg);

		_ObjHTML.divphoto.find("#div-img").prepend(_ListView.image.prop("outerHTML"));

		_Foto.push(iNamaImg);
	}

    Form                = function()
    {
        _Questionnaire  = JSON.parse(JSIAndroid.showForm());

		SetHeader();

        for(var i = 0; i < _Questionnaire.quest.length; ++i)
        {
            _ListView.question.attr("id", i);
            _ListView.question.find(".timeline-header").html(_Questionnaire.quest[i]);

            _ObjHTML.divquestionnaire.append(_ListView.question.prop("outerHTML"));
            _ObjHTML.divquestionnaire.find("#"+i+" .list-group-item").on("click", SetScore);

			_DetScore.push([0,0,0,0]);
        }
		_ObjHTML.divquestionnaire.append("<li class=\"time-label\"> <span style=\"background-color: #00838f; color: white; width: 50px;\"> SA: <span id=\"s-keberadaan\">0</span> </span> <span style=\"background-color: #00838f; color: white; width: 50px;\"> SL: <span id=\"s-lokasi\">0</span> </span> <span style=\"background-color: #00838f; color: white; width: 50px;\"> SK: <span id=\"s-kondisi\">0</span> </span> <span style=\"background-color: #00838f; color: white; width: 50px;\"> SF: <span id=\"s-fungsi\">0</span> </span> <span style=\"background-color: #424242; color: white; width: 120px;\"> TOTAL: <span id=\"s-total\">0</span> </span> </li>");

		var aDate	= new Date();
		var aMonth	= aDate.getMonth() + 1 <= 9 ? "0"+(aDate.getMonth() + 1)	: aDate.getMonth() + 1;
		var aDay	= aDate.getDate() <= 9	? "0"+aDate.getDate()	: aDate.getDate();
		_ObjHTML.divsurveyor.find("#tanggal").val(aDate.getFullYear()+"-"+aMonth+"-"+aDay);
	}

	SetHeader 			= function()
	{
		var aHeaderData	= _Questionnaire.header.split("#");

		for(var i = 0; i < _ObjHTML.divheader.find("p").length; ++i)
		{
			$(_ObjHTML.divheader.find("b")[i]).html(aHeaderData[i].toUpperCase());
		}
	}

	SetGPS 				= function()
	{
		JSIAndroid.vibrate();
		JSIAndroid.setGPS();

		var aID	= $(this).attr("id");

		var aLat	= JSIAndroid.getLat();
		var aLong	= JSIAndroid.getLong();
		$("#"+aID).closest(".list-group-item").find(".form-control").val(aLat+","+aLong);
	}

    SetScore            = function()
    {
        JSIAndroid.vibrate();
		var aIndex	= {
			keberadaan	: 0,
			lokasi 		: 1,
			kondisi 	: 2,
			fungsi 		: 3
		}

        var aScore      = $(this).attr("data-score") === undefined ? 1 : parseInt($(this).attr("data-score")) * -1;
        var aScoreType  = $(this).attr("id");

        if(aScore === 1)
        {
            var aFontColor  = "white";
            var aBgColor	= "#2e7d32";
        }
        else
        {
            var aFontColor	= "black";
            var aBgColor    = "white";
        }
        $(this).css("background-color", aBgColor);
		$(this).find("p").css("color", aFontColor);

        _Score[aScoreType]  = _Score[aScoreType] + aScore;

		_DetScore[parseInt($(this).closest("li").attr("id"))][aIndex[aScoreType]] = aScore == -1 ? 0 : aScore;

        CountScore();

        $(this).attr("data-score", aScore);
    }

    CountScore          = function()
    {
        _Score.total    = parseFloat(((parseFloat(_Score.keberadaan + _Score.lokasi + _Score.kondisi + _Score.fungsi) / 4.00) / parseFloat(_Questionnaire.quest.length)) * 100.00).toFixed(2);

        var aBgColor    = "#d32f2f";
        if(parseFloat(_Score.total) >= 50 && parseFloat(_Score.total) <= 80)  aBgColor    = "#f57f17";
        else if(parseFloat(_Score.total) > 80)                                aBgColor    = "#33691e";

        _ObjHTML.divquestionnaire.find("#s-total").parent().css("background-color", aBgColor);
        _ObjHTML.divquestionnaire.find("#s-total").html(_Score.total);

        _ObjHTML.divquestionnaire.find("#s-keberadaan").html(_Score.keberadaan);
        _ObjHTML.divquestionnaire.find("#s-lokasi").html(_Score.lokasi);
        _ObjHTML.divquestionnaire.find("#s-fungsi").html(_Score.fungsi);
        _ObjHTML.divquestionnaire.find("#s-kondisi").html(_Score.kondisi);
    }

    Save                = function()
    {
        JSIAndroid.vibrate();

		if(_ObjHTML.divsurveyor.find("#nama").val() == "" || _ObjHTML.divsurveyor.find("#nama-ruas").val() == "" || _ObjHTML.divsurveyor.find("#kode-ruas").val() == "" || _ObjHTML.divsurveyor.find("#koordinat-awal").val() == "" || _ObjHTML.divsurveyor.find("#koordinat-akhir").val() == "")
		{
			getNotification(1, "Terdapat kolom yang kosong");
		}
		else
		{
			var aResTotal = _DetScore.map(function(iCurrScore)
			{
				return iCurrScore.join("-");
			}).join("|");

			var aData 	= {
				nama_surveyor	: _ObjHTML.divsurveyor.find("#nama").val(),
				tanggal			: _ObjHTML.divsurveyor.find("#tanggal").val(),
				nama_ruas		: _ObjHTML.divsurveyor.find("#nama-ruas").val(),
				kode_ruas		: _ObjHTML.divsurveyor.find("#kode-ruas").val(),
				koor_awal		: _ObjHTML.divsurveyor.find("#koordinat-awal").val(),
				koor_akhir		: _ObjHTML.divsurveyor.find("#koordinat-akhir").val(),
				rincian_total	: aResTotal,
				total			: _Score.total,
				catatan         : _ObjHTML.divnote.find(".form-control").val(),
				form_id			: _Questionnaire.id,
				user_id			: 1,
				foto			: _Foto
			};

			JSIAndroid.saveData(JSON.stringify(aData));
		}
    }

    Form();

	_ObjHTML.divsurveyor.find("#btn-gps-awal").on("click", SetGPS);
	_ObjHTML.divsurveyor.find("#btn-gps-akhir").on("click", SetGPS);
	_ObjHTML.divphoto.find("#btn-camera").on("click", function(){ JSIAndroid.vibrate(); JSIAndroid.getCamera(); });
    _ObjHTML.btnsave.on("click", Save);
}
