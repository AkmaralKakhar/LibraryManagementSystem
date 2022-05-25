package kz.iitu.itse1907.akmaral.jms;

//import org.dom4j.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.jms.JMSException;

@RestController
@RequestMapping(value = "/jms")
public class JmsController {
    @Autowired
    private MessageSender messageSender;

    @Autowired
    private MessageReceiver messageReceiver;

    @Autowired
    private MessagingConfiguration messagingConfiguration;

    @PostMapping("/sendMessage/{text}")
    public String sendMessage(@PathVariable String text) throws JMSException {
        messageSender.sendMessage(text);
        return  "Message " + text + " has been sent successfully...";
    }

    @GetMapping("/receiveMessage")
    @ResponseStatus(HttpStatus.OK)
    public String getMessage() throws JMSException {
        String receiveMsq = messageReceiver.receiveMessage();
        return "Message " + receiveMsq + " get from queue";
    }
}