package websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

/**
 * @author yan
 * @date 2018/11/2 14:38
 * @descripition
 */
public class MarcoHandler extends AbstractWebSocketHandler {
    private static final Logger logger = LoggerFactory.getLogger(MarcoHandler.class);
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        logger.info("Received message"+ message.getPayload());
        Thread.sleep(2000);
        session.sendMessage(new TextMessage("polo!"));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.info("ConnectionClosed");
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("ConnectionEstablished");
        logger.info("ConnectionEstablished");
    }
}
