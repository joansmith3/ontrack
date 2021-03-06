package net.ontrack.core.support;

import com.google.common.base.Function;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMessageAnnotator extends AbstractMessageAnnotator {

    private final Pattern pattern;
    private final Function<String, MessageAnnotation> annotationFactory;

    public RegexMessageAnnotator(String pattern, Function<String, MessageAnnotation> annotationFactory) {
        this(Pattern.compile(pattern), annotationFactory);
    }

    public RegexMessageAnnotator(Pattern pattern, Function<String, MessageAnnotation> annotationFactory) {
        this.pattern = pattern;
        this.annotationFactory = annotationFactory;
    }

    @Override
    public Collection<MessageAnnotation> annotate(String text) {
        Collection<MessageAnnotation> annotations = new ArrayList<>();
        int start = 0;
        Matcher m = pattern.matcher(text);
        while (m.find()) {
            int mStart = m.start();
            int mEnd = m.end();
            // Previous section
            if (mStart > start) {
                String previous = text.substring(start, mStart);
                annotations.add(MessageAnnotation.t(previous));
            }
            // Match
            String match = m.group(1);
            MessageAnnotation annotation = annotationFactory.apply(match);
            annotations.add(annotation);
            // Next
            start = mEnd;
        }
        // End
        if (start < text.length() - 1) {
            String reminder = text.substring(start);
            annotations.add(MessageAnnotation.t(reminder));
        }
        // OK
        return annotations;
    }
}
