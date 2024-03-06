package com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.applovin.mediation.ads.MaxAdView;
import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.R;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import android.view.MenuItem;
import android.view.View;

import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.Adapter.RecyclerContentAdapter;
import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.Model.Guns;


public class ImageActivity extends AppCompatActivity {

    Toolbar toolBarImage;
    RecyclerView recyclerView;
    ArrayList<Guns> imageList = new ArrayList<>();

    // For Banner Ad-App-Lovin
    MaxAdView maxBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        // -----> Banner AppLovin Ad
        maxBanner = findViewById(R.id.maxBannerAd);
        maxBanner.setVisibility(View.VISIBLE);
        maxBanner.loadAd();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // get data from intent
        int imgContent = getIntent().getIntExtra("layoutContent", 1);

        // Set the title in the action bar
        toolBarImage = findViewById(R.id.toolBarImage);
        setSupportActionBar(toolBarImage);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        // AK-47 image content
        if (imgContent == 1) {
            getSupportActionBar().setTitle("AK-47");
            imageList.add(new Guns(1, R.drawable.img1, "0"));
            imageList.add(new Guns(2 ,R.drawable.img2, "0"));
            imageList.add(new Guns(3 ,R.drawable.img3, "0"));
            imageList.add(new Guns(4 ,R.drawable.img4, "0"));
            imageList.add(new Guns(5 ,R.drawable.img5, "0"));
            imageList.add(new Guns(6 ,R.drawable.img6, "0"));
            imageList.add(new Guns(7 ,R.drawable.img7, "0"));
            imageList.add(new Guns(8 ,R.drawable.img8, "0"));
            imageList.add(new Guns(9 ,R.drawable.img9, "0"));
            imageList.add(new Guns(10,R.drawable.img10, "0"));
            imageList.add(new Guns(11,R.drawable.img11, "0"));
            imageList.add(new Guns(12,R.drawable.img12, "0"));
            imageList.add(new Guns(13,R.drawable.img13, "0"));
            imageList.add(new Guns(14,R.drawable.img14, "0"));
            imageList.add(new Guns(15,R.drawable.img15, "0"));
            imageList.add(new Guns(16,R.drawable.img16, "0"));
            imageList.add(new Guns(17,R.drawable.img17, "0"));
            imageList.add(new Guns(18,R.drawable.img18, "0"));
            imageList.add(new Guns(19,R.drawable.img19, "0"));
            imageList.add(new Guns(20,R.drawable.img20, "0"));
            imageList.add(new Guns(21,R.drawable.img21, "0"));
            imageList.add(new Guns(22,R.drawable.img22, "0"));
            imageList.add(new Guns(23,R.drawable.img23, "0"));
            imageList.add(new Guns(24,R.drawable.img24, "0"));
            imageList.add(new Guns(25,R.drawable.img25, "0"));
            imageList.add(new Guns(26,R.drawable.img26, "0"));
            imageList.add(new Guns(27,R.drawable.img27, "0"));
            imageList.add(new Guns(28,R.drawable.img28, "0"));
            imageList.add(new Guns(29,R.drawable.img29, "0"));
            imageList.add(new Guns(30,R.drawable.img30, "0"));
            imageList.add(new Guns(31,R.drawable.img31, "0"));
            imageList.add(new Guns(32,R.drawable.img32, "0"));
            imageList.add(new Guns(33,R.drawable.img33, "0"));
            imageList.add(new Guns(34,R.drawable.img34, "0"));
            imageList.add(new Guns(35,R.drawable.img35, "0"));
            imageList.add(new Guns(36,R.drawable.img36, "0"));
            imageList.add(new Guns(37,R.drawable.img37, "0"));
            imageList.add(new Guns(38,R.drawable.img38, "0"));
            imageList.add(new Guns(39,R.drawable.img39, "0"));
            imageList.add(new Guns(40,R.drawable.img40, "0"));
        }

        // M416 image content
        else if (imgContent == 2) {
            getSupportActionBar().setTitle("M416");
            imageList.add(new Guns(41,R.drawable.img41,"0"));
            imageList.add(new Guns(42,R.drawable.img42,"0"));
            imageList.add(new Guns(43,R.drawable.img43,"0"));
            imageList.add(new Guns(44,R.drawable.img44,"0"));
            imageList.add(new Guns(45,R.drawable.img45,"0"));
            imageList.add(new Guns(46,R.drawable.img46,"0"));
            imageList.add(new Guns(47,R.drawable.img47,"0"));
            imageList.add(new Guns(48,R.drawable.img48,"0"));
            imageList.add(new Guns(49,R.drawable.img49,"0"));
            imageList.add(new Guns(50,R.drawable.img50,"0"));
            imageList.add(new Guns(51,R.drawable.img51,"0"));
            imageList.add(new Guns(52,R.drawable.img52,"0"));
            imageList.add(new Guns(53,R.drawable.img53,"0"));
            imageList.add(new Guns(54,R.drawable.img54,"0"));
            imageList.add(new Guns(55,R.drawable.img55,"0"));
            imageList.add(new Guns(56,R.drawable.img56,"0"));
            imageList.add(new Guns(57,R.drawable.img57,"0"));
            imageList.add(new Guns(58,R.drawable.img58,"0"));
            imageList.add(new Guns(59,R.drawable.img59,"0"));
            imageList.add(new Guns(60,R.drawable.img60,"0"));
            imageList.add(new Guns(61,R.drawable.img61,"0"));
            imageList.add(new Guns(62,R.drawable.img62,"0"));
            imageList.add(new Guns(63,R.drawable.img63,"0"));
            imageList.add(new Guns(64,R.drawable.img64,"0"));
            imageList.add(new Guns(65,R.drawable.img65,"0"));
            imageList.add(new Guns(66,R.drawable.img66,"0"));
            imageList.add(new Guns(67,R.drawable.img67,"0"));
            imageList.add(new Guns(68,R.drawable.img68,"0"));
            imageList.add(new Guns(69,R.drawable.img69,"0"));
            imageList.add(new Guns(70,R.drawable.img70,"0"));
            imageList.add(new Guns(71,R.drawable.img71,"0"));
            imageList.add(new Guns(72,R.drawable.img72,"0"));
            imageList.add(new Guns(73,R.drawable.img73,"0"));
            imageList.add(new Guns(74,R.drawable.img74,"0"));
            imageList.add(new Guns(75,R.drawable.img75,"0"));
            imageList.add(new Guns(76,R.drawable.img76,"0"));
            imageList.add(new Guns(77,R.drawable.img77,"0"));
            imageList.add(new Guns(78,R.drawable.img78,"0"));
            imageList.add(new Guns(79,R.drawable.img79,"0"));
            imageList.add(new Guns(80,R.drawable.img80,"0"));
        }

        // Kalashnikov image content
        else if (imgContent == 3) {
            getSupportActionBar().setTitle("Kalashnikova");
            imageList.add(new Guns(312,R.drawable.img312,"0"));
            imageList.add(new Guns(313,R.drawable.img313,"0"));
            imageList.add(new Guns(314,R.drawable.img314,"0"));
            imageList.add(new Guns(315,R.drawable.img315,"0"));
            imageList.add(new Guns(316,R.drawable.img316,"0"));
            imageList.add(new Guns(317,R.drawable.img317,"0"));
            imageList.add(new Guns(318,R.drawable.img318,"0"));
            imageList.add(new Guns(319,R.drawable.img319,"0"));
            imageList.add(new Guns(320,R.drawable.img320,"0"));
            imageList.add(new Guns(321,R.drawable.img321,"0"));
            imageList.add(new Guns(322,R.drawable.img322,"0"));
            imageList.add(new Guns(323,R.drawable.img323,"0"));
            imageList.add(new Guns(324,R.drawable.img324,"0"));
            imageList.add(new Guns(325,R.drawable.img325,"0"));
            imageList.add(new Guns(326,R.drawable.img326,"0"));
            imageList.add(new Guns(327,R.drawable.img327,"0"));
            imageList.add(new Guns(328,R.drawable.img328,"0"));
            imageList.add(new Guns(329,R.drawable.img329,"0"));
            imageList.add(new Guns(330,R.drawable.img330,"0"));
            imageList.add(new Guns(331,R.drawable.img331,"0"));
        }

        // Beretta image content
        else if (imgContent == 4) {
            getSupportActionBar().setTitle("Beretta");
            imageList.add(new Guns(332,R.drawable.img332,"0"));
            imageList.add(new Guns(333,R.drawable.img333,"0"));
            imageList.add(new Guns(334,R.drawable.img334,"0"));
            imageList.add(new Guns(335,R.drawable.img335,"0"));
            imageList.add(new Guns(336,R.drawable.img336,"0"));
            imageList.add(new Guns(337,R.drawable.img337,"0"));
            imageList.add(new Guns(338,R.drawable.img338,"0"));
            imageList.add(new Guns(339,R.drawable.img339,"0"));
            imageList.add(new Guns(340,R.drawable.img340,"0"));
            imageList.add(new Guns(341,R.drawable.img341,"0"));
            imageList.add(new Guns(342,R.drawable.img342,"0"));
            imageList.add(new Guns(343,R.drawable.img343,"0"));
            imageList.add(new Guns(344,R.drawable.img344,"0"));
            imageList.add(new Guns(345,R.drawable.img345,"0"));
            imageList.add(new Guns(346,R.drawable.img346,"0"));
            imageList.add(new Guns(347,R.drawable.img347,"0"));
            imageList.add(new Guns(348,R.drawable.img348,"0"));
            imageList.add(new Guns(349,R.drawable.img349,"0"));
            imageList.add(new Guns(350,R.drawable.img350,"0"));
            imageList.add(new Guns(351,R.drawable.img351,"0"));
        }

        // AR-15 image content
        else if (imgContent == 5) {
            getSupportActionBar().setTitle("AR-15");
            imageList.add(new Guns(208,R.drawable.img208,"0"));
            imageList.add(new Guns(209,R.drawable.img209,"0"));
            imageList.add(new Guns(210,R.drawable.img210,"0"));
            imageList.add(new Guns(211,R.drawable.img222,"0"));
            imageList.add(new Guns(212,R.drawable.img212,"0"));
            imageList.add(new Guns(213,R.drawable.img213,"0"));
            imageList.add(new Guns(214,R.drawable.img214,"0"));
            imageList.add(new Guns(215,R.drawable.img215,"0"));
            imageList.add(new Guns(216,R.drawable.img216,"0"));
            imageList.add(new Guns(217,R.drawable.img217,"0"));
            imageList.add(new Guns(218,R.drawable.img218,"0"));
            imageList.add(new Guns(219,R.drawable.img219,"0"));
            imageList.add(new Guns(220,R.drawable.img220,"0"));
            imageList.add(new Guns(221,R.drawable.img221,"0"));
            imageList.add(new Guns(222,R.drawable.img222,"0"));
            imageList.add(new Guns(223,R.drawable.img223,"0"));
            imageList.add(new Guns(224,R.drawable.img224,"0"));
            imageList.add(new Guns(225,R.drawable.img225,"0"));
            imageList.add(new Guns(226,R.drawable.img226,"0"));
            imageList.add(new Guns(227,R.drawable.img227,"0"));
            imageList.add(new Guns(228,R.drawable.img228,"0"));
            imageList.add(new Guns(229,R.drawable.img220,"0"));
            imageList.add(new Guns(230,R.drawable.img230,"0"));
        }

        // Sniper image content
        else if (imgContent == 6) {
            getSupportActionBar().setTitle("Sniper");
            imageList.add(new Guns(121,R.drawable.img121,"0"));
            imageList.add(new Guns(122,R.drawable.img122,"0"));
            imageList.add(new Guns(123,R.drawable.img123,"0"));
            imageList.add(new Guns(124,R.drawable.img124,"0"));
            imageList.add(new Guns(125,R.drawable.img125,"0"));
            imageList.add(new Guns(126,R.drawable.img126,"0"));
            imageList.add(new Guns(127,R.drawable.img127,"0"));
            imageList.add(new Guns(128,R.drawable.img128,"0"));
            imageList.add(new Guns(129,R.drawable.img129,"0"));
            imageList.add(new Guns(130,R.drawable.img130,"0"));
            imageList.add(new Guns(131,R.drawable.img131,"0"));
            imageList.add(new Guns(132,R.drawable.img132,"0"));
            imageList.add(new Guns(133,R.drawable.img133,"0"));
            imageList.add(new Guns(134,R.drawable.img134,"0"));
            imageList.add(new Guns(135,R.drawable.img135,"0"));
            imageList.add(new Guns(136,R.drawable.img136,"0"));
            imageList.add(new Guns(137,R.drawable.img137,"0"));
            imageList.add(new Guns(138,R.drawable.img138,"0"));
            imageList.add(new Guns(139,R.drawable.img139,"0"));
            imageList.add(new Guns(140,R.drawable.img140,"0"));
            imageList.add(new Guns(141,R.drawable.img141,"0"));
            imageList.add(new Guns(142,R.drawable.img142,"0"));
            imageList.add(new Guns(143,R.drawable.img143,"0"));
            imageList.add(new Guns(144,R.drawable.img144,"0"));
            imageList.add(new Guns(145,R.drawable.img145,"0"));
            imageList.add(new Guns(146,R.drawable.img146,"0"));
            imageList.add(new Guns(147,R.drawable.img147,"0"));
            imageList.add(new Guns(148,R.drawable.img148,"0"));
            imageList.add(new Guns(149,R.drawable.img149,"0"));
            imageList.add(new Guns(150,R.drawable.img150,"0"));
            imageList.add(new Guns(151,R.drawable.img151,"0"));
            imageList.add(new Guns(152,R.drawable.img152,"0"));
            imageList.add(new Guns(153,R.drawable.img153,"0"));
            imageList.add(new Guns(154,R.drawable.img154,"0"));
            imageList.add(new Guns(155,R.drawable.img155,"0"));
            imageList.add(new Guns(156,R.drawable.img156,"0"));
            imageList.add(new Guns(157,R.drawable.img157,"0"));
            imageList.add(new Guns(158,R.drawable.img158,"0"));
            imageList.add(new Guns(159,R.drawable.img159,"0"));
            imageList.add(new Guns(160,R.drawable.img160,"0"));
        }

        // Mossberg, Remington image content
        else if (imgContent == 7) {
            getSupportActionBar().setTitle("Mossberg, Remington");
            imageList.add(new Guns(161,R.drawable.img161,"0"));
            imageList.add(new Guns(162,R.drawable.img162,"0"));
            imageList.add(new Guns(163,R.drawable.img163,"0"));
            imageList.add(new Guns(164,R.drawable.img164,"0"));
            imageList.add(new Guns(165,R.drawable.img165,"0"));
            imageList.add(new Guns(166,R.drawable.img166,"0"));
            imageList.add(new Guns(169,R.drawable.img169,"0"));
            imageList.add(new Guns(170,R.drawable.img170,"0"));
            imageList.add(new Guns(171,R.drawable.img171,"0"));
            imageList.add(new Guns(172,R.drawable.img172,"0"));
            imageList.add(new Guns(173,R.drawable.img173,"0"));
            imageList.add(new Guns(174,R.drawable.img174,"0"));
            imageList.add(new Guns(175,R.drawable.img175,"0"));
            imageList.add(new Guns(176,R.drawable.img176,"0"));
            imageList.add(new Guns(177,R.drawable.img177,"0"));
            imageList.add(new Guns(178,R.drawable.img178,"0"));
            imageList.add(new Guns(179,R.drawable.img179,"0"));
            imageList.add(new Guns(180,R.drawable.img180,"0"));
            imageList.add(new Guns(181,R.drawable.img181,"0"));
            imageList.add(new Guns(182,R.drawable.img182,"0"));
        }

        // Tommy Gun image content
        else if (imgContent == 8) {
            getSupportActionBar().setTitle("Tommy Gun");
            imageList.add(new Guns(183,R.drawable.img183,"0"));
            imageList.add(new Guns(184,R.drawable.img184,"0"));
            imageList.add(new Guns(185,R.drawable.img185,"0"));
            imageList.add(new Guns(186,R.drawable.img186,"0"));
            imageList.add(new Guns(187,R.drawable.img187,"0"));
            imageList.add(new Guns(188,R.drawable.img188,"0"));
            imageList.add(new Guns(189,R.drawable.img189,"0"));
            imageList.add(new Guns(190,R.drawable.img190,"0"));
            imageList.add(new Guns(191,R.drawable.img191,"0"));
            imageList.add(new Guns(192,R.drawable.img192,"0"));
            imageList.add(new Guns(193,R.drawable.img193,"0"));
            imageList.add(new Guns(194,R.drawable.img194,"0"));
            imageList.add(new Guns(195,R.drawable.img195,"0"));
            imageList.add(new Guns(196,R.drawable.img196,"0"));
            imageList.add(new Guns(197,R.drawable.img197,"0"));
            imageList.add(new Guns(198,R.drawable.img198,"0"));
            imageList.add(new Guns(199,R.drawable.img199,"0"));
            imageList.add(new Guns(200,R.drawable.img200,"0"));
            imageList.add(new Guns(201,R.drawable.img201,"0"));
            imageList.add(new Guns(202,R.drawable.img202,"0"));
            imageList.add(new Guns(203,R.drawable.img203,"0"));
            imageList.add(new Guns(204,R.drawable.img204,"0"));
            imageList.add(new Guns(205,R.drawable.img205,"0"));
            imageList.add(new Guns(206,R.drawable.img206,"0"));
            imageList.add(new Guns(207,R.drawable.img207,"0"));
        }

        // 9mm image content
        else if (imgContent == 9) {
            getSupportActionBar().setTitle("9mm");
            imageList.add(new Guns(81,R.drawable.img81,"0"));
            imageList.add(new Guns(82,R.drawable.img82,"0"));
            imageList.add(new Guns(83,R.drawable.img83,"0"));
            imageList.add(new Guns(84,R.drawable.img84,"0"));
            imageList.add(new Guns(85,R.drawable.img85,"0"));
            imageList.add(new Guns(86,R.drawable.img86,"0"));
            imageList.add(new Guns(87,R.drawable.img87,"0"));
            imageList.add(new Guns(88,R.drawable.img88,"0"));
            imageList.add(new Guns(89,R.drawable.img89,"0"));
            imageList.add(new Guns(90,R.drawable.img90,"0"));
            imageList.add(new Guns(91,R.drawable.img91,"0"));
            imageList.add(new Guns(92,R.drawable.img92,"0"));
            imageList.add(new Guns(93,R.drawable.img93,"0"));
            imageList.add(new Guns(94,R.drawable.img94,"0"));
            imageList.add(new Guns(95,R.drawable.img95,"0"));
            imageList.add(new Guns(96,R.drawable.img96,"0"));
            imageList.add(new Guns(97,R.drawable.img97,"0"));
            imageList.add(new Guns(98,R.drawable.img98,"0"));
            imageList.add(new Guns(99,R.drawable.img99,"0"));
            imageList.add(new Guns(100,R.drawable.img100,"0"));
            imageList.add(new Guns(101,R.drawable.img101,"0"));
            imageList.add(new Guns(102,R.drawable.img102,"0"));
            imageList.add(new Guns(103,R.drawable.img103,"0"));
            imageList.add(new Guns(104,R.drawable.img104,"0"));
            imageList.add(new Guns(105,R.drawable.img105,"0"));
            imageList.add(new Guns(106,R.drawable.img106,"0"));
            imageList.add(new Guns(107,R.drawable.img107,"0"));
            imageList.add(new Guns(108,R.drawable.img108,"0"));
            imageList.add(new Guns(109,R.drawable.img109,"0"));
            imageList.add(new Guns(110,R.drawable.img110,"0"));
            imageList.add(new Guns(111,R.drawable.img111,"0"));
            imageList.add(new Guns(112,R.drawable.img112,"0"));
            imageList.add(new Guns(113,R.drawable.img113,"0"));
            imageList.add(new Guns(114,R.drawable.img114,"0"));
            imageList.add(new Guns(115,R.drawable.img115,"0"));
            imageList.add(new Guns(116,R.drawable.img116,"0"));
            imageList.add(new Guns(117,R.drawable.img117,"0"));
            imageList.add(new Guns(118,R.drawable.img118,"0"));
            imageList.add(new Guns(119,R.drawable.img119,"0"));
            imageList.add(new Guns(120,R.drawable.img120,"0"));
        }

        // M16A1 image content
        else if (imgContent == 10) {
            getSupportActionBar().setTitle("M16A1");
            imageList.add(new Guns(231,R.drawable.img231,"0"));
            imageList.add(new Guns(232,R.drawable.img232,"0"));
            imageList.add(new Guns(233,R.drawable.img233,"0"));
            imageList.add(new Guns(234,R.drawable.img234,"0"));
            imageList.add(new Guns(235,R.drawable.img235,"0"));
            imageList.add(new Guns(236,R.drawable.img236,"0"));
            imageList.add(new Guns(237,R.drawable.img237,"0"));
            imageList.add(new Guns(238,R.drawable.img238,"0"));
            imageList.add(new Guns(239,R.drawable.img239,"0"));
            imageList.add(new Guns(240,R.drawable.img240,"0"));
            imageList.add(new Guns(241,R.drawable.img241,"0"));
            imageList.add(new Guns(242,R.drawable.img242,"0"));
            imageList.add(new Guns(243,R.drawable.img243,"0"));
            imageList.add(new Guns(244,R.drawable.img244,"0"));
            imageList.add(new Guns(245,R.drawable.img245,"0"));
            imageList.add(new Guns(246,R.drawable.img246,"0"));
            imageList.add(new Guns(247,R.drawable.img247,"0"));
            imageList.add(new Guns(248,R.drawable.img248,"0"));
            imageList.add(new Guns(249,R.drawable.img249,"0"));
            imageList.add(new Guns(250,R.drawable.img250,"0"));
            imageList.add(new Guns(251,R.drawable.img251,"0"));
            imageList.add(new Guns(252,R.drawable.img252,"0"));
        }

        // P90 image content
        else if (imgContent == 11) {
            getSupportActionBar().setTitle("P90");
            imageList.add(new Guns(253,R.drawable.img253,"0"));
            imageList.add(new Guns(254,R.drawable.img254,"0"));
            imageList.add(new Guns(255,R.drawable.img255,"0"));
            imageList.add(new Guns(256,R.drawable.img256,"0"));
            imageList.add(new Guns(257,R.drawable.img257,"0"));
            imageList.add(new Guns(258,R.drawable.img258,"0"));
            imageList.add(new Guns(259,R.drawable.img259,"0"));
            imageList.add(new Guns(260,R.drawable.img260,"0"));
            imageList.add(new Guns(261,R.drawable.img261,"0"));
            imageList.add(new Guns(262,R.drawable.img262,"0"));
            imageList.add(new Guns(263,R.drawable.img263,"0"));
            imageList.add(new Guns(264,R.drawable.img264,"0"));
            imageList.add(new Guns(266,R.drawable.img265,"0"));
            imageList.add(new Guns(266,R.drawable.img266,"0"));
            imageList.add(new Guns(268,R.drawable.img268,"0"));
            imageList.add(new Guns(269,R.drawable.img269,"0"));
            imageList.add(new Guns(270,R.drawable.img270,"0"));
            imageList.add(new Guns(271,R.drawable.img271,"0"));
            imageList.add(new Guns(272,R.drawable.img272,"0"));
        }

        // Type 95 image content
        else if (imgContent == 12) {
            getSupportActionBar().setTitle("Type 95");
            imageList.add(new Guns(273,R.drawable.img273,"0"));
            imageList.add(new Guns(274,R.drawable.img274,"0"));
            imageList.add(new Guns(275,R.drawable.img275,"0"));
            imageList.add(new Guns(276,R.drawable.img276,"0"));
            imageList.add(new Guns(277,R.drawable.img277,"0"));
            imageList.add(new Guns(278,R.drawable.img278,"0"));
            imageList.add(new Guns(279,R.drawable.img279,"0"));
            imageList.add(new Guns(280,R.drawable.img280,"0"));
            imageList.add(new Guns(281,R.drawable.img281,"0"));
            imageList.add(new Guns(282,R.drawable.img282,"0"));
            imageList.add(new Guns(283,R.drawable.img283,"0"));
            imageList.add(new Guns(284,R.drawable.img284,"0"));
            imageList.add(new Guns(285,R.drawable.img285,"0"));
            imageList.add(new Guns(286,R.drawable.img286,"0"));
            imageList.add(new Guns(287,R.drawable.img287,"0"));
            imageList.add(new Guns(288,R.drawable.img288,"0"));
            imageList.add(new Guns(289,R.drawable.img289,"0"));
            imageList.add(new Guns(290,R.drawable.img290,"0"));
        }

        // UMP45 image content
        else if (imgContent == 13) {
            getSupportActionBar().setTitle("UMP45");
            imageList.add(new Guns(291,R.drawable.img291,"0"));
            imageList.add(new Guns(292,R.drawable.img292,"0"));
            imageList.add(new Guns(293,R.drawable.img293,"0"));
            imageList.add(new Guns(294,R.drawable.img294,"0"));
            imageList.add(new Guns(295,R.drawable.img295,"0"));
            imageList.add(new Guns(296,R.drawable.img296,"0"));
            imageList.add(new Guns(297,R.drawable.img297,"0"));
            imageList.add(new Guns(298,R.drawable.img298,"0"));
            imageList.add(new Guns(299,R.drawable.img299,"0"));
            imageList.add(new Guns(300,R.drawable.img300,"0"));
            imageList.add(new Guns(301,R.drawable.img301,"0"));
            imageList.add(new Guns(302,R.drawable.img302,"0"));
            imageList.add(new Guns(303,R.drawable.img303,"0"));
            imageList.add(new Guns(304,R.drawable.img304,"0"));
            imageList.add(new Guns(305,R.drawable.img305,"0"));
            imageList.add(new Guns(306,R.drawable.img306,"0"));
            imageList.add(new Guns(307,R.drawable.img307,"0"));
            imageList.add(new Guns(308,R.drawable.img308,"0"));
            imageList.add(new Guns(309,R.drawable.img309,"0"));
            imageList.add(new Guns(310,R.drawable.img310,"0"));
            imageList.add(new Guns(311,R.drawable.img311,"0"));
        }

        RecyclerContentAdapter adapter = new RecyclerContentAdapter(this, imageList);
        recyclerView.setAdapter(adapter);

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}