package elm.common.constants;

/**
 * Redis键值
 *
 * @author zzw
 * @version 2023/9/27 15:02
 */
public class RedisConstants
{

    /**
     * businessList-key:按销量排序
     */
    public static final String REDIS_BUSINESS_SORT_BY_ORDER_NUM_KEY = "business-sort-by-sale:";
    /**
     * businessList-key:按评分排序
     */
    public static final String REDIS_BUSINESS_SORT_BY_STARS_KEY = "business-sort-by-score:";

    /**
     * redis-loginToken-key
     */
    public static String REDIS_LOGIN_KEY = "elm-user-login:";
}
