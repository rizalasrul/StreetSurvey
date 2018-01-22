function Menu(iObjHTML)
{
	var _Config 	= new Config();

    var _Type       = "a1"; // JSIAndroid.getType();

	var _ListView 	= _Config.VIEWLIST.menu;
	var _ObjHTML 	= iObjHTML == undefined ? {} : iObjHTML;

	var _Self 		= this;

	var _ListMenu 	= [];

    Menu                = function()
    {
	     _ListMenu  = JSON.parse(JSIAndroid.showFormMenu());

		for(var i = 0; i < _ListMenu.length; ++i)
 		{
			_ListView.menu.attr("id", i);
			_ListView.menu.find("#title").html(_ListMenu[i].title);
			_ListView.menu.find("#menu").html(_ListMenu[i].menu.toUpperCase());

			_ObjHTML.divmenus.append(_ListView.menu.prop("outerHTML"));
			_ObjHTML.divmenus.find("#"+i).on("click", {id : _ListMenu[i].menu}, function(iEvent){ JSIAndroid.vibrate(); JSIAndroid.menu(iEvent.data.id); });
 		}
	}

	Search 				= function()
	{
		var aQuery 	= $(this).val();

		_ObjHTML.divmenus.empty();
		for(var i = 0; i < _ListMenu.length; ++i)
		{
			if(_ListMenu[i].title.toUpperCase().indexOf(aQuery.toUpperCase()) > -1 || _ListMenu[i].menu.toUpperCase().indexOf(aQuery.toUpperCase()) > -1)
			{
				_ListView.menu.attr("id", i);
				_ListView.menu.find("#title").html(_ListMenu[i].title);
				_ListView.menu.find("#menu").html(_ListMenu[i].menu.toUpperCase());

				_ObjHTML.divmenus.append(_ListView.menu.prop("outerHTML"));
				_ObjHTML.divmenus.find("#"+i).on("click", {id : _ListMenu[i].menu}, function(iEvent){ JSIAndroid.vibrate(); JSIAndroid.menu(iEvent.data.id); });
			}
		}
	}

    Menu();

	_ObjHTML.inpsearch.on("input", Search);
}
