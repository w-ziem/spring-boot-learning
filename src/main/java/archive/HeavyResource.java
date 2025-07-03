package archive;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy //won't be created until needed
public class HeavyResource {
    public HeavyResource() {
        System.out.println("HeavyResource created");
    }
}
