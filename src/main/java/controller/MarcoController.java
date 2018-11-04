package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import websocket.Shout;

/**
 * @author yan
 * @date 2018/11/3 20:04
 * @descripition
 */
@Controller
public class MarcoController {
    private static final Logger logger = LoggerFactory.getLogger(MarcoController.class);
    @MessageMapping("/marco")
    public Shout handleShout(Shout incoming){
        System.out.println("++++++++++++");
        logger.info("Received message"+ incoming.getMessage());
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        Shout outgoing = new Shout();
        outgoing.setMessage("Polo!");
        return outgoing;
    }
}
