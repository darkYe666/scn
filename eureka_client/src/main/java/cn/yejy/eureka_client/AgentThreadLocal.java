package cn.yejy.eureka_client;

/**
 * @author ye
 * @date 2019-05-08
 */
public class AgentThreadLocal {
    private AgentThreadLocal() {
    }

    //ConsoleUserVo是存储用户信息的实体类我就不说了
    private static final ThreadLocal<ConsoleUserVo> LOCAL = new ThreadLocal<ConsoleUserVo>();

    public static void set(ConsoleUserVo user) {
        LOCAL.set(user);
    }

    public static ConsoleUserVo get() {
        return LOCAL.get();
    }

    public static void remove() {
        LOCAL.remove();
    }
}
