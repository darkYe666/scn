package cn.yejy.eureka_client;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @author ye
 * @date 2019-05-08
 */
@WebListener
public class SessionListenner implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if ("userInfo".equals(event.getName())) {
            AgentThreadLocal.set((ConsoleUserVo) event.getValue());
        }
    }

    @Override
    //销毁session时触发
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if ("userInfo".equals(event.getName())) {
            AgentThreadLocal.remove();
        }
    }

    @Override
    //替换session时触发
    public void attributeReplaced(HttpSessionBindingEvent event) {
        if ("userInfo".equals(event.getName())) {
            AgentThreadLocal.set((ConsoleUserVo) event.getValue());
        }
    }
}
