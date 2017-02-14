package ru.innopolis.log4j;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.helpers.PatternConverter;
import org.apache.log4j.spi.LoggingEvent;

/**
 * Created by fedinskiy on 14.02.17.
 */
public class MailLayout extends PatternLayout{
    private PatternConverter topic;
    private String topicPattern;
    protected final int BUF_SIZE;
    protected final int MAX_CAPACITY;
    private StringBuffer sbuf;

    public MailLayout() {
        super();
        this.BUF_SIZE = 256;
        this.MAX_CAPACITY = 1024;
        this.sbuf = new StringBuffer(256);
    }

    public MailLayout(String textPattern, String topicpattern) {
        super(textPattern);
        this.BUF_SIZE = 256;
        this.MAX_CAPACITY = 1024;
        this.sbuf = new StringBuffer(256);
        this.topicPattern = topicpattern;
        this.topic = this.createPatternParser(topicpattern == null?"%m%n": topicpattern)
                .parse();
    }

    public String formatTopic(LoggingEvent event){
        return "topic:"+format(event);
    }
    public String formatText(LoggingEvent event){
        return "Text:"+super.format(event);
    }
    @Override
    public String format(LoggingEvent event) {
        if(this.sbuf.capacity() > 1024) {
            this.sbuf = new StringBuffer(256);
        } else {
            this.sbuf.setLength(0);
        }

        for(PatternConverter c = this.topic; c != null; c = c.next) {
            c.format(this.sbuf, event);
        }

        return this.sbuf.toString();
    }

    public void setTopicPattern(String topicPattern) {
        this.topicPattern = topicPattern;
        this.topic = this.createPatternParser(topicPattern).parse();
    }

    public String getTopicPattern() {
        return this.topicPattern;
    }


}
