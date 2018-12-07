package com.zlcdgroup.jetpacksample.ui.index.lottery.data

/**
 *
 * "lottery_id":"ssq",
 * "lottery_name":"双色球",
 * "lottery_type_id":"1",
 * "remarks":"每周二、四、日开奖"
 */
class LotteryType(var lottery_id: String, var lottery_name: String, var lottery_type_id: String, var remarks: String)

/**
 * 某期彩票各等级奖金，每期可能不同
 *"prize_name":"一等奖",
 *"prize_num":"2",
 *"prize_amount":"623,987",
 *"prize_require":"7+0"
 */
class LotteryPrize(var prize_name: String, var prize_num: String, var prize_amount: String, var prize_require: String)

/**
 * 某期彩票开奖情况
 * "lottery_id":"qlc",
 *"lottery_name":"七乐彩",
 *"lottery_res":"05,07,08,12,14,26,28,09",
 *"lottery_no":"18143",
 *"lottery_date":"2018-12-05",
 *"lottery_exdate":"2019-02-02",
 *"lottery_sale_amount":"5,831,552",
 *"lottery_pool_amount":"0",
 *"lottery_prize":[
 */
class LotteryOpenResult {
    var lottery_id: String? = null
    var lottery_name: String? = null
    var lottery_res: String? = null
    var lottery_no: String? = null
    var lottery_date: String? = null
    var lottery_exdate: String? = null
    var lottery_sale_amount: String? = null
    var lottery_pool_amount: String? = null
    var lottery_prize: List<LotteryPrize>? = null
}


/**
 * 简版开奖结果
 */
class LotteryOpenResultSimple {
    var lottery_id: String? = null
    var lottery_res: String? = null
    var lottery_no: String? = null
    var lottery_date: String? = null
    var lottery_exdate: String? = null
    var lottery_sale_amount: String? = null
    var lottery_pool_amount: String? = null
}

/**
 * 历史开奖结果列表
 */
class LotteryResList {
    var lotteryResList: List<LotteryOpenResultSimple>? = null
    var page: Int? = null
    var pageSize: Int? = null
    var totalPage: Int? = null
}

/**
 * 中奖结果查询
 */
class LotteryBonusResult{
    var lottery_id: String? = null
    var lottery_name: String? = null
    var lottery_no: String? = null
    var lottery_date: String? = null
    var real_lottery_res: String? = null
    var lottery_res: String? = null
    var in_money: String? = null
    var buy_red_ball_num: String? = null
    var buy_blue_ball_num: String? = null
    var hit_red_ball_num: String? = null
    var hit_blue_ball_num: String? = null
    var is_prize: String? = null
    var prize_msg: String? = null
    var lottery_prize: String? = null
}





