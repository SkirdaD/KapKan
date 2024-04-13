package com.example.kapkan.Data.OldData

import com.example.kapkan.Data.Retrofit.Hangul
import com.example.kapkan.Data.Retrofit.Hanja
import com.example.kapkan.Data.Retrofit.NumberData
import com.example.kapkan.Data.Retrofit.NumbersData
import com.example.kapkan.Data.Retrofit.Russian

class OldData {

    data class HanjaRecord(
        val syllable: Hanja,
        val koreanSound: Hangul,
        val hundok: Hangul = "",
        val translationRU: List<Russian> = listOf(),
        /*    val eumhan: Hangul,

            val translationENG: English,*/
        /*
            val transliterationRU: Russian,
            val transliterationENG: English,*/
        /*
            val memoHelpRU: Russian = "",
            val memoHelpENG: English = "",
            val tags: Tags*/
    )


    enum class Tags {
        SIZE, COLORS, RELATIVES, COUNTRIES, SHAPES, LANGUAGES, DIRECTIONS, SENSES, BODYPARTS, ORGANS,
        CITIES, SEOUL, MOUNTAINS
    }

    val n1 = NumberData(9, "ff", "fff")
    val n2 = NumberData(8, "dd", "ddd")
    val numbers = NumbersData(arrayListOf(n1, n2))


    val koreanNumbers = mapOf(
        1 to "하나",
        2 to "둘",
        3 to "셋",
        4 to "넷",
        5 to "다섯",
        6 to "여섯",
        7 to "일곱",
        8 to "여덟",
        9 to "아홉",
        10 to "열",
        20 to "스물",
        30 to "서른",
        40 to "마흔",
        50 to "쉰",
        60 to "예순",
        70 to "일흔",
        80 to "여든",
        90 to "아흔",
        100 to "온",
        1000 to "즈믄",
        10000 to "드먼",
        100000000 to "잘",
        //1000000000000 to "울"
    )

    val hanja11 = arrayListOf(
        HanjaRecord("中", "중"),
        HanjaRecord("山", "산"),
        HanjaRecord("門", "문"),
        HanjaRecord("入", "입"),
        HanjaRecord("出", "출"),
        HanjaRecord("口", "구"),
        HanjaRecord("上", "상"),
        HanjaRecord("下", "하"),
        HanjaRecord("日", "일"),
        HanjaRecord("月", "월"),
        HanjaRecord("年", "년"),
        HanjaRecord("內", "내"),
        HanjaRecord("外", "외"),
        HanjaRecord("人", "인"),
        HanjaRecord("子", "자"),
        HanjaRecord("父", "부"),
        HanjaRecord("母", "모"),
        HanjaRecord("男", "남"),
        HanjaRecord("女", "여"),
        HanjaRecord("一", "일"),
        HanjaRecord("二", "이"),
        HanjaRecord("三", "삼"),
        HanjaRecord("四", "사"),
        HanjaRecord("五", "오"),
        HanjaRecord("六", "육"),
        HanjaRecord("七", "칠"),
        HanjaRecord("八", "팔"),
        HanjaRecord("九", "구"),
        HanjaRecord("十", "십"),
        HanjaRecord("東", "동"),
        HanjaRecord("西", "서"),
        HanjaRecord("北", "북"),
        HanjaRecord("南", "남"),
        HanjaRecord("王", "왕"),
        HanjaRecord("天", "천"),
        HanjaRecord("手", "수"),
        HanjaRecord("字", "자"),
        HanjaRecord("員", "원"),
    )

    val hanjaNew = arrayListOf(
        HanjaRecord("韓", "한"),
        HanjaRecord("國", "국"),
        HanjaRecord("民", "민"),
        HanjaRecord("美", "미"),
        HanjaRecord("漢", "한"),
        HanjaRecord("江", "강"),
        HanjaRecord("水", "수"),
        HanjaRecord("川", "천"),
        HanjaRecord("冷", "냉"),
        HanjaRecord("本", "본"),
        HanjaRecord("心", "심"),
        HanjaRecord("身", "신"),
        HanjaRecord("體", "체"),
        HanjaRecord("感", "감"),
        HanjaRecord("家", "가"),
        HanjaRecord("名", "명"),
        HanjaRecord("品", "품"),
        HanjaRecord("金", "금"),
        HanjaRecord("李", "이"),
        HanjaRecord("正", "정"),
        HanjaRecord("無", "무"),
        HanjaRecord("不", "부"),
        HanjaRecord("用", "용"),
        HanjaRecord("半", "반"),
        HanjaRecord("白", "백"),
        HanjaRecord("學", "학"),
        HanjaRecord("生", "생"),
        HanjaRecord("校", "교"),
        HanjaRecord("先", "선"),
        HanjaRecord("師", "사"),
        HanjaRecord("公", "공"),
        HanjaRecord("市", "시"),
        HanjaRecord("區", "구"),
        HanjaRecord("洞", "동"),
        HanjaRecord("合", "합"),
        HanjaRecord("場", "장"),
        HanjaRecord("室", "실"),
        HanjaRecord("食", "식"),
        HanjaRecord("地", "지"),
        HanjaRecord("方", "방"),
        HanjaRecord("時", "시"),
        HanjaRecord("期", "기"),
        HanjaRecord("間", "간"),
        HanjaRecord("同", "동"),
        HanjaRecord("百", "백"),
        HanjaRecord("部", "부"),
        HanjaRecord("分", "분"),
        HanjaRecord("多", "다"),
        HanjaRecord("數", "수"),
        HanjaRecord("全", "전"),
        HanjaRecord("新", "신"),
        HanjaRecord("現", "현"),
        HanjaRecord("代", "대"),
        HanjaRecord("文", "문"),
        HanjaRecord("化", "화"),
        HanjaRecord("力", "력"),
        HanjaRecord("强", "강"),
        HanjaRecord("弱", "약"),
        HanjaRecord("火", "화"),
        HanjaRecord("信", "신"),
        HanjaRecord("土", "토"),
        HanjaRecord("世", "세"),
        HanjaRecord("木", "목"),
        HanjaRecord("球", "구"),
        HanjaRecord("立", "립"),
        HanjaRecord("監督", "감독", translationRU = listOf("присмотр")),
        HanjaRecord("作品", "작품", translationRU = listOf("творческая работа")),
        HanjaRecord("友邦", "우방", translationRU = listOf("союзник")),
        HanjaRecord(
            "綠色",
            "녹색",
            translationRU = listOf("зелёный цвет", "зелёный", "зеленый", "зеленый цвет")
        ),
        HanjaRecord("同一", "동일", translationRU = listOf("идентичность", "одинаковость")),
        HanjaRecord("專門", "전문", translationRU = listOf("спешалти", "специализированный", "спец")),
        HanjaRecord("公", "공", "공평할", listOf("общественное", "государственное")),
        HanjaRecord("今", "금", "이제", listOf("этот", "текущий", "сейчас")),
        HanjaRecord("參", "참", "참여할", listOf("участвовать", "присоединяться")),
        HanjaRecord("囧", "경", "빛날", listOf("сиять", "бысть светлым")),
        HanjaRecord("悶", "민", "답답할 ", listOf("агония", "страдать")),
        HanjaRecord("今始初聞", "금시초문", "답답할 ", listOf("это что-то новое", "that's news to me")),
        HanjaRecord("與", "여", "더불", listOf("и", "c", "к", "для", "давать")),
        HanjaRecord("體育", "체육", "-", listOf("физкультура")),
        HanjaRecord("時", "시", "때", listOf("время")),
        HanjaRecord("工具", "공구", "-", listOf("инструмент")),
        HanjaRecord("午後", "오후", "-", listOf("p.m.")),
        HanjaRecord("勿", "물", "아닐", listOf("нельзя", "запрещено", "без", "отсутствует")),
        HanjaRecord("切", "절", "끊을", listOf("резать")),
        HanjaRecord("詞", "사", "말", listOf("слово")),
        HanjaRecord("代", "대", "대신할/세대", listOf("заменять", "поколение")),
        HanjaRecord("此", "차", "이", listOf("здесь", "этот")),
        HanjaRecord("此日彼日", "차일피일", "-", listOf("прокрастинация", "откладывание")),
        HanjaRecord("改善", "개선", "-", listOf("улучшение", "реформа")),
        HanjaRecord("世", "세", "인간(人間)", listOf("мир", "поколение")),
        HanjaRecord(
            "簡",
            "간",
            "대쪽",
            listOf("простой", "несложный", "краткий", "письмо", "выбирать")
        ),
        HanjaRecord(
            "曲",
            "곡",
            "굽을",
            listOf(
                "согнутый",
                "скрученный",
                "изогнутый",
                "счётн. для музыкальных произведений",
                "счётн. мелодий"
            )
        ),
        HanjaRecord("影", "영", "그림자", listOf("тень")),
        HanjaRecord("片", "편", "조각", listOf("кусочек", "слайс", "остаток")),
        HanjaRecord("街娼", "가창", "-", listOf("проститутка", "ночная бабочка")),
        HanjaRecord("訓", "훈", "가르칠"),
        HanjaRecord("音", "음", "소리", listOf("звук", "новости", "произношение", "разговор")),
    )
}