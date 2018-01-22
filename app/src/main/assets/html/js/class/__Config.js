function Config()
{
    var _HTMLElements   = {
        question    : "<li>"+
                      "  <i class=\"fa fa-question\" style=\"background-color: #00acc1; color: white;\"></i>"+
                      "  <div class=\"timeline-item\">"+
                      "    <h3 class=\"timeline-header\"></h3>"+
                      "    <div class=\"timeline-body\" style=\"padding: 0px;\">"+
                      "      <div class=\"row\">"+
                      "        <div class=\"col-xs-6\" style=\"padding-right: 0px;\">"+
                      "          <a id=\"keberadaan\" class=\"list-group-item\" style=\"padding-top: 0px; padding-bottom: 0px; border-radius: 0px;\">"+
                      "            <div class=\"row\">"+
                      "              <div class=\"col-xs-12\" style=\"padding: 10px;\" align=\"center\">"+
                      "                <p style=\"font-size: 12px; margin: 0px; color: black;\"><b>KEBERADAAN</b></p>"+
                      "              </div>"+
                      "            </div>"+
                      "          </a>"+
                      "        </div>"+
                      "        <div class=\"col-xs-6\" style=\"padding-left: 0px;\">"+
                      "          <a id=\"lokasi\" class=\"list-group-item\" style=\"padding-top: 0px; padding-bottom: 0px; border-radius: 0px;\">"+
                      "            <div class=\"row\">"+
                      "              <div class=\"col-xs-12\" style=\"padding: 10px;\" align=\"center\">"+
                      "                <p style=\"font-size: 12px; margin: 0px; color: black;\"><b>LOKASI</b></p>"+
                      "              </div>"+
                      "            </div>"+
                      "          </a>"+
                      "        </div>"+
                      "        <div class=\"col-xs-6\" style=\"padding-right: 0px;\">"+
                      "          <a id=\"kondisi\" class=\"list-group-item\" style=\"padding-top: 0px; padding-bottom: 0px; border-radius: 0px;\">"+
                      "            <div class=\"row\">"+
                      "              <div class=\"col-xs-12\" style=\"padding: 10px;\" align=\"center\">"+
                      "                <p style=\"font-size: 12px; margin: 0px; color: black;\"><b>KONDISI</b></p>"+
                      "              </div>"+
                      "            </div>"+
                      "          </a>"+
                      "        </div>"+
                      "        <div class=\"col-xs-6\" style=\"padding-left: 0px;\">"+
                      "          <a id=\"fungsi\" class=\"list-group-item\" style=\"padding-top: 0px; padding-bottom: 0px; border-radius: 0px;\">"+
                      "            <div class=\"row\">"+
                      "              <div class=\"col-xs-12\" style=\"padding: 10px;\" align=\"center\">"+
                      "                <p style=\"font-size: 12px; margin: 0px; color: black;\"><b>FUNGSI</b></p>"+
                      "              </div>"+
                      "            </div>"+
                      "          </a>"+
                      "        </div>"+
                      "      </div>"+
                      "    </div>"+
                      "  </div>"+
                      "</li>",
        image       : "<div class=\"col-xs-3\">"+
                      "  <div class=\"small-box bg-gray\" style=\"height: 50px;\">"+
                      "    <img src=\"\" style=\"height: 100%; width: 100%\" />"+
                      "  </div>"+
                      "</div>",
        menu        : "<a class=\"list-group-item no-padding\" style=\"background-color: white; border-left: 4px solid #29b6f6; border-right: none; border-radius: 0px;\">"+
                      "  <div class=\"row\">"+
                      "    <div class=\"col-xs-9\">"+
                      "      <h4 class=\"list-group-item-heading\" style=\"font-size: 14px; color: black; padding: 5px;\" id=\"title\"></h4>"+
                      "    </div>"+
                      "    <div class=\"col-xs-3\" style=\"background-color: #29b6f6;\" align=\"center\">"+
                      "      <p style=\"font-size: 30px; color: white;\"><b id=\"menu\"></b></p>"+
                      "    </div>"+
                      "  </div>"+
                      "</a>"
    };

    this.VIEWLIST       = {
        form        : {
            question    : $(_HTMLElements.question),
            image       : $(_HTMLElements.image)
        },
        menu        : {
            menu        : $(_HTMLElements.menu)
        }
    }

    this.MENULIST   = [{
        menu    : "a1",
        title   : "Jurang"
    },{
        menu    : "a2",
        title   : "Jalan"
    },{
        menu    : "a3",
        title   : "Terjal"
    },{
        menu    : "a4",
        title   : "Berliku"
    },{
        menu    : "a5",
        title   : "Galau"
    }];

    this.QUESTIONNAIRE  = {
        a  : [{
            header  : "Normal/Lurus#Hutan/Sawah#Datar#A1",
            quest   : ["Marka garis terluar", "Marka garis putus-putus", "Marka garis ganda", "Marka penunjuk arah", "Penerangan jalan umum (PJU)"]
        }, {
            header  : "A - 2. Antar Kota Ruas Normal (Lurus) -- Jurang/Tebing",
            quest   : ["Rambu larangan mendahului", "Rambu peringatan jurang", "Rambu batas kecepatan", "Marka garis terluar", "Guard rail", "Marka garis putus-putus", "Rambu akhir batas kecepatan",
                       "Rambu akhir larangan mendahului", "Pita penggaduh", "Marka garis ganda", "Marka penunjuk arah", "Penerangan jalan umum (PJU)"]
        }, {
            header  : "A - 3. Antar Kota Ruas Normal (Lurus) -- Sekolah",
            quest   : ["Marka garis terluar", "Marka garis putus-putus", "Lampu kedip kuning warning LED", "Rambu peringatan penyebrangan", "Rambu tempat penyebrangan", "Pita penggaduh",
                       "Marka garis ganda", "Marka penunjuk arah", "Penerangan jalan umum (PJU)", "Marka dilarang berhenti", "Zebra cross", "Marka ZoSS", "Rambu kecepatan max. 30 KM/Jam",
                       "Rambu peringatan ZoSS"]
        }, {
            header  : "A - 4. Antar Kota Ruas Normal (Lurus) -- Perdagangan",
            quest   : ["Marka garis terluar", "Marka garis putus-putus", "Petunjuk lokasi perdagangan", "Pita penggaduh", "Rambu peringatan penyebrangan", "Rambu tempat penyebrangan",
                       "Marka garis ganda", "Marka penunjuk arah", "Penerangan jalan umum (PJU)", "Zebra cross", "Marga garis henti"]
        }, {
            header  : "A - 5. Antar Kota Ruas Normal (Lurus) -- Perkantoran",
            quest   : ["Marka garis terluar", "Marka garis putus-putus", "Lampu kedip kuning warning LED", "Petunjuk lokasi perkantoran", "Pita penggaduh", "Rambu peringatan penyebrangan",
                       "Rambu tempat penyebrangan", "Marka garis ganda", "Marka penunjuk arah", "Penerangan jalan umum (PJU)", "Zebra cross", "Marka garis henti"]
        }, {
            header  : "A - 6. Antar Kota Ruas Normal (Lurus) -- Permukiman",
            quest   : ["Marka garis terluar", "Marka garis putus-putus", "Rambu kecepatan max. 50 KM/Jam", "Pita penggaduh", "Rambu peringatan penyebrangan", "Rambu tempat penyebrangan",
                       "Marka garis ganda", "Penerangan jalan umum (PJU)", "Zebra cross", "Marka garis henti"]
        }, {
            header  : "A - 7. Antar Kota Ruas Normal (Lurus) -- Industri",
            quest   : ["Marka garis terluar", "Marka garis putus-putus", "Lampu kedip kuning warning LED", "Rambu kecepatan max. 50 KM/Jam", "Pita penggaduh", "Rambu peringatan penyebrangan",
                       "Rambu tempat penyebrangan", "Marka garis ganda", "Marka penunjuk arah", "Penerangan jalan umum (PJU)", "Zebra cross", "Marka garis henti"]
        }, {
            header  : "A - 8. Perkotaan Ruas Normal (Lurus) -- Area CBD",
            quest   : ["Marka garis terluar", "Marka garis putus-putus", "Rambu kecepatan max. 50 KM/Jam", "Pita penggaduh", "Rambu peringatan penyebrangan", "Rambu tempat penyebrangan",
                       "Marka garis ganda", "Marka penunjuk arah", "Penerangan jalan umum (PJU)", "Zebra cross", "Marka garis henti"]
        }, {
            header  : "A - 9. Perkotaan Ruas Normal (Lurus) -- Sekolah",
            quest   : ["Marka garis terluar", "Marka garis putus-putus", "Lampu kedip kuning warning LED", "Rambu peringatan penyebrangan", "Rambu tempat penyebrangan", "Pita penggaduh",
                       "Marka garis ganda", "Marka penunjuk arah", "Penerangan jalan umum (PJU)", "Marka dilarang berhenti", "Zebra cross", "Marka ZoSS", "Rambu kecepatan max. 30 KM/Jam",
                       "Rambu peringatan ZoSS"]
        }, {
            header  : "A - 10. Perkotaan Ruas Normal (Lurus) -- Perdagangan",
            quest   : ["Marka garis terluar", "Marka garis putus-putus", "Petunjuk lokasi perdagangan", "Pita penggaduh", "Rambu peringatan penyebrangan", "Rambu tempat penyebrangan",
                       "Marka garis ganda", "Marka penunjuk arah", "Penerangan jalan umum (PJU)", "Zebra cross", "Marka garis henti"]
        }, {
            header  : "A - 11. Perkotaan Ruas Normal (Lurus) -- Perkantoran",
            quest   : ["Marka garis terluar", "Marka garis putus-putus", "Lampu kedip kuning warning LED", "Petunjuk lokasi perkantoran", "Pita penggaduh", "Rambu peringatan penyebrangan",
                       "Rambu tempat penyebrangan", "Marka garis ganda", "Marka penunjuk arah", "Penerangan jalan umum (PJU)", "Zebra cross", "Marka garis henti"]
        }, {
            header  : "A - 12. Perkotaan Ruas Normal (Lurus) -- Permukiman",
            quest   : ["Marka garis terluar", "Marka garis putus-putus", "Rambu kecepatan max. 50 KM/Jam", "Pita penggaduh", "Rambu peringatan penyebrangan", "Rambu tempat penyebrangan",
                       "Marka garis ganda", "Marka penunjuk arah", "Penerangan jalan umum (PJU)", "Zebra cross", "Marka garis henti"]
        }],
        b  : [{
            header  : "B - 1. Antar Kota Tikungan Kanan -- Hutan/sawah",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Chevron Alignment Marker (CAM)", "Delineator", "Marka pemisah garis utuh", "Marka tepi menerus", "Paku jalan",
                       "Penerangan jalan umum (PJU)"]
        }, {
            header  : "B - 2. Antar Kota Tikungan Kanan -- Jurang/tebing",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Rambu batas kecepatan", "Rambu peringatan hati-hati", "Delineator", "Chevron Alignment Marker (CAM)", "Guard rail",
                       "Rambu akhir larangan mendahului", "Rambu akhir batas kecepatan", "Marka tepi garis utuh", "Marka pemisah garis utuh", "Paku jalan", "Penerangan jalan umum (PJU)"]
        }, {
            header  : "B - 3. Antar Kota Tikungan Kanan -- Sekolah",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Rambu batas kecepatan", "Rambu peringatan hati-hati", "Delineator", "Chevron Alignment Marker (CAM)", "Paku jalan",
                       "Rambu peringatan penyebrangan", "Rambu akhir batas kecepatan", "Rambu akhir larangan mendahului", "Pita penggaduh", "Rambu tempat penyebrangan", "Zebra cross", "Marka ZoSS",
                       "Marka tepi garis utuh", "Marka pemisah garis utuh", "Rambu penunjuk lokasi sekolah", "Rambu peringatan ZoSS", "Penerangan jalan umum (PJU)", "Lampu kedip kuning warning LED"]
        }, {
            header  : "B - 4. Antar Kota Tikungan Kanan -- Perdagangan",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Rambu batas kecepatan", "Rambu peringatan hati-hati", "Delineator", "Chevron Alignment Marker (CAM)", "Paku jalan",
                       "Rambu petunjuk lokasi perdagangan", "Rambu akhir batas kecepatan", "Rambu akhir larangan mendahului", "Pita penggaduh", "Rambu tempat penyebrangan", "Zebra cross",
                       "Garis henti", "Marka tepi garis utuh", "Marka pemisah garis utuh", "Rambu peringatan penyebrangan", "Penerangan jalan umum (PJU)"]
        }, {
            header  : "B - 5. Antar Kota Tikungan Kanan -- Perkantoran",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Rambu batas kecepatan", "Rambu peringatan hati-hati", "Delineator", "Chevron Alignment Marker (CAM)", "Paku jalan",
                       "Rambu petunjuk lokasi Perkantoran", "Rambu akhir batas kecepatan", "Rambu akhir larangan mendahului", "Pita penggaduh", "Rambu tempat penyebrangan", "Zebra cross",
                       "Garis henti", "Marka tepi garis utuh", "Marka pemisah garis utuh", "Rambu peringatan penyebrangan", "Penerangan jalan umum (PJU)", "Lampu kedip kuning warning (LED)"]
        }, {
            header  : "B - 6. Antar Kota Tikungan Kanan -- Pemukiman",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Rambu batas kecepatan", "Rambu peringatan hati-hati", "Delineator", "Chevron Alignment Marker (CAM)", "Paku jalan",
                       "Rambu kecepatan max. 50 KM/Jam", "Rambu akhir batas kecepatan", "Rambu akhir larangan mendahului", "Pita penggaduh", "Rambu tempat penyebrangan", "Zebra cross",
                       "Garis henti", "Marka tepi garis utuh", "Marka pemisah garis utuh", "Rambu peringatan penyebrangan", "Penerangan jalan umum (PJU)", "Lampu kedip kuning warning (LED)"]
        }, {
            header  : "B - 7. Antar Kota Tikungan Kanan -- Industri",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Rambu batas kecepatan", "Rambu peringatan hati-hati", "Delineator", "Chevron Alignment Marker (CAM)", "Paku jalan",
                       "Rambu kecepatan max. 50 KM/Jam", "Rambu akhir batas kecepatan", "Rambu akhir larangan mendahului", "Pita penggaduh", "Rambu tempat penyebrangan", "Zebra cross",
                       "Garis henti", "Marka tepi garis utuh", "Marka pemisah garis utuh", "Rambu peringatan penyebrangan", "Penerangan jalan umum (PJU)", "Lampu kedip kuning warning (LED)"]
        }, {
            header  : "B - 8. Perkotaan Tikungan Kanan -- Area CBD",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Rambu batas kecepatan", "Rambu peringatan hati-hati", "Delineator", "Chevron Alignment Marker (CAM)", "Paku jalan",
                       "Rambu kecepatan max. 50 KM/Jam", "Rambu akhir batas kecepatan", "Rambu akhir larangan mendahului", "Pita penggaduh", "Rambu tempat penyebrangan", "Zebra cross",
                       "Garis henti", "Marka tepi garis utuh", "Marka pemisah garis utuh", "Rambu peringatan penyebrangan", "Penerangan jalan umum (PJU)"]
        }, {
            header  : "B - 9. Perkotaan Tikungan Kantor -- Sekolah",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Rambu batas kecepatan", "Rambu peringatan hati-hati", "Delineator", "Chevron Alignment Marker (CAM)", "Paku jalan",
                       "Rambu peringatan penyebrangan", "Rambu akhir batas kecepatan", "Rambu akhir larangan mendahului", "Pita penggaduh", "Rambu tempat penyebrangan", "Zebra cross",
                       "Marka ZoSS", "Marka tepi garis utuh", "Marka pemisah garis utuh", "Rambu petunjuk lokasi sekolah", "Rambu peringatan ZoSS", "Penerangan jalan umum (PJU)", "Lampu kedip kuning warning (LED)"]
        }, {
            header  : "B - 10. Perkotaan Tikungan Kanan -- Perdagangan",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Rambu batas kecepatan", "Rambu peringatan hati-hati", "Delineator", "Chevron Alignment Marker (CAM)", "Paku jalan",
                       "Rambu petunjuk lokasi perdagangan", "Rambu akhir batas kecepatan", "Rambu akhir larangan mendahului", "Pita penggaduh", "Rambu tempat penyebrangan", "Zebra cross",
                       "Garis henti", "Marka tepi garis utuh", "Marka pemisah garis utuh", "Rambu peringatan penyebrangan", "Penerangan jalan umum (PJU)"]
        }, {
            header  : "B - 11. Perkotaan Tikungan Kanan -- Perkantoran",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Rambu batas kecepatan", "Rambu peringatan hati-hati", "Delineator", "Chevron Alignment Marker (CAM)", "Paku jalan",
                       "Rambu petunjuk lokasi Perkantoran", "Rambu akhir batas kecepatan", "Rambu akhir larangan mendahului", "Pita penggaduh", "Rambu tempat penyebrangan", "Zebra cross",
                       "Garis henti", "Marka tepi garis utuh", "Marka pemisah garis utuh", "Rambu peringatan penyebrangan", "Penerangan jalan umum (PJU)", "Lampu kedip kuning warning (LED)"]
        }, {
            header  : "B - 12. Perkotaan Tikungan Kanan -- Permukiman",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Rambu batas kecepatan", "Rambu peringatan hati-hati", "Delineator", "Chevron Alignment Marker (CAM)", "Paku jalan",
                       "Rambu kecepatan max. 50 KM/Jam", "Rambu akhir batas kecepatan", "Rambu akhir larangan mendahului", "Pita penggaduh", "Rambu tempat penyebrangan", "Zebra cross",
                       "Garis henti", "Marka tepi garis utuh", "Marka pemisah garis utuh", "Rambu peringatan penyebrangan", "Penerangan jalan umum (PJU)", "Lampu kedip kuning warning (LED)"]
        }],
        c   : [{
            header  : "C - 1. Antar Kota Tikungan Kiri -- Hutan Sawah",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Chevron Alignment Marker (CAM)", "Delineator", "Marka pemisah garis utuh", "Marka tepi menerus", "Paku jalan",
                       "Penerangan jalan umum (PJU)"]
        }, {
            header  : "C - 2. Antar Kota Tikungan Kiri -- Jurang/tebing",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Rambu batas kecepatan", "Rambu peringatan hati-hati", "Delineator", "Chevron Alignment Marker (CAM)", "Guard rail",
                       "Rambu akhir larangan mendahului", "Rambu akhir batas kecepatan", "Marka tepi garis utuh", "Marka pemisah garis utuh", "Paku jalan", "Penerangan jalan umum (PJU)"]
        }, {
            header  : "C - 3. Antar Kota Tikungan Kiri -- Sekolah",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Rambu batas kecepatan", "Rambu peringatan hati-hati", "Delineator", "Chevron Alignment Marker (CAM)", "Paku jalan",
                       "Rambu peringatan penyebrangan", "Rambu akhir batas kecepatan", "Rambu akhir larangan mendahului", "Pita penggaduh", "Rambu tempat penyebrangan", "Zebra cross", "Marka ZoSS",
                       "Marka tepi garis utuh", "Marka pemisah garis utuh", "Rambu petunjuk lokasi sekolah", "Rambu peringatan ZoSS", "Penerangan jalan umum (PJU)", "Lampu kedip kuning warning (LED)"]
        }, {
            header  : "C - 4. Antar Kota Tikungan Kiri -- Perdagangan",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Rambu batas kecepatan", "Rambu peringatan hati-hati", "Delineator", "Chevron Alignment Marker (CAM)", "Paku jalan",
                       "Rambu petunjuk lokasi perdagangan", "Rambu akhir batas kecepatan", "Rambu akhir larangan mendahului", "Pita penggaduh", "Rambu tempat penyebrangan", "Zebra cross", "Garis henti",
                       "Marka tepi garis utuh", "Marka pemisah garis utuh", "Rambu peringatan penyebrangan", "Penerangan jalan umum (PJU)"]
        }, {
            header  : "C - 5. Antar Kota Tikungan Kiri -- Perkantoran",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Rambu batas kecepatan", "Rambu peringatan hati-hati", "Delineator", "Chevron Alignment Marker (CAM)", "Paku jalan",
                       "Rambu petunjuk lokasi perkantoran", "Rambu akhir batas kecepatan", "Rambu akhir larangan mendahului", "Pita penggaduh", "Rambu tempat penyebrangan", "Zebra cross", "Garis henti",
                       "Marka tepi garis utuh", "Marka pemisah garis utuh", "Rambu peringatan penyebrangan", "Penerangan jalan umum (PJU)", "Lampu kedip kuning warning (LED)"]
        }, {
            header  : "C - 6. Antar Kota Tikungan Kiri -- Pemukiman",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Rambu batas kecepatan", "Rambu peringatan hati-hati", "Delineator", "Chevron Alignment Marker (CAM)", "Paku jalan",
                       "Rambu kecepatan max. 50 KM/Jam", "Rambu akhir batas kecepatan", "Rambu akhir larangan mendahului", "Pita penggaduh", "Rambu tempat penyebrangan", "Zebra cross", "Garis henti",
                       "Marka tepi garis utuh", "Marka pemisah garis utuh", "Rambu peringatan penyebrangan", "Penerangan jalan umum (PJU)"]
        }, {
            header  : "C - 7. Antar Kota Tikungan Kiri -- Industri",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Rambu batas kecepatan", "Rambu peringatan hati-hati", "Delineator", "Chevron Alignment Marker (CAM)", "Paku jalan",
                       "Rambu kecepatan max. 50 KM/Jam", "Rambu akhir batas kecepatan", "Rambu akhir larangan mendahului", "Pita penggaduh", "Rambu tempat penyebrangan", "Zebra cross", "Garis henti",
                       "Marka tepi garis utuh", "Marka pemisah garis utuh", "Rambu peringatan penyebrangan", "Penerangan jalan umum (PJU)", "Lampu kedip kuning warning (LED)"]
        }, {
            header  : "C - 8. Perkotaan Tikungan Kiri -- Area CBD",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Rambu batas kecepatan", "Rambu peringatan hati-hati", "Delineator", "Chevron Alignment Marker (CAM)", "Paku jalan",
                       "Rambu kecepatan max. 50 KM/Jam", "Rambu akhir batas kecepatan", "Rambu akhir larangan mendahului", "Pita penggaduh", "Rambu tempat penyebrangan", "Zebra cross", "Garis henti",
                       "Marka tepi garis utuh", "Marka pemisah garis utuh", "Rambu peringatan penyebrangan", "Penerangan jalan umum (PJU)"]
        }, {
            header  : "C - 9. Perkotaan Tikungan Kiri -- Sekolah",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Rambu batas kecepatan", "Rambu peringatan hati-hati", "Delineator", "Chevron Alignment Marker (CAM)", "Paku jalan",
                       "Rambu peringatan penyebrangan", "Rambu akhir batas kecepatan", "Rambu akhir larangan mendahului", "Pita penggaduh", "Rambu tempat penyebrangan", "Zebra cross", "Marka ZoSS",
                       "Marka tepi garis utuh", "Marka pemisah garis utuh", "Rambu petunjuk lokasi sekolah", "Rambu peringatan ZoSS", "Penerangan jalan umum (PJU)", "Lampu kedip kuning warning (LED)"]
        }, {
            header  : "C - 10. Perkotaan Tikungan Kiri -- Perdagangan",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Rambu batas kecepatan", "Rambu peringatan hati-hati", "Delineator", "Chevron Alignment Marker (CAM)", "Paku jalan",
                       "Rambu petunjuk lokasi perdagangan", "Rambu akhir batas kecepatan", "Rambu akhir larangan mendahului", "Pita penggaduh", "Rambu tempat penyebrangan", "Zebra cross", "Garis henti",
                       "Marka tepi garis utuh", "Marka pemisah garis utuh", "Rambu peringatan penyebrangan", "Penerangan jalan umum (PJU)"]
        }, {
            header  : "C - 11. Perkotaan Tikungan Kiri -- Perkantoran",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Rambu batas kecepatan", "Rambu peringatan hati-hati", "Delineator", "Chevron Alignment Marker (CAM)", "Paku jalan",
                       "Rambu petunjuk lokasi perkantoran", "Rambu akhir batas kecepatan", "Rambu akhir larangan mendahului", "Pita penggaduh", "Rambu tempat penyebrangan", "Zebra cross", "Garis henti",
                       "Marka tepi garis utuh", "Marka pemisah garis utuh", "Rambu peringatan penyebrangan", "Penerangan jalan umum (PJU)", "Lampu kedip kuning warning (LED)"]
        }, {
            header  : "C - 12. Perkotaan Tikungan Kiri -- Permukiman",
            quest   : ["Rambu peringatan tikungan", "Rambu larangan mendahului", "Rambu batas kecepatan", "Rambu peringatan hati-hati", "Delineator", "Chevron Alignment Marker (CAM)", "Paku jalan",
                       "Rambu kecepatan max. 50 KM/Jam", "Rambu akhir batas kecepatan", "Rambu akhir larangan mendahului", "Pita penggaduh", "Rambu tempat penyebrangan", "Zebra cross", "Garis henti",
                       "Marka tepi garis utuh", "Marka pemisah garis utuh", "Rambu peringatan penyebrangan", "Penerangan jalan umum (PJU)"]
        }]
    }
}

/*  JS Global Static Function
===================================== */
function getNotification(iType, iMsg) // Push notification
{
  	var aStat   = "success";
  	if(iType == 1)
  	{
  	  	aStat   = "warn";
  	}
  	else if(iType == 2)
  	{
  	  	aStat   = "error";
  	}

  	$.notify(iMsg, aStat);
}
function setLoading(iIsLoading) // Show/hide loading animation
{
	if(iIsLoading == 0)
    {
        $(".overlay").hide();
    }
    else
    {
        $(".overlay").show();
    }
}
/*  ================================ */
