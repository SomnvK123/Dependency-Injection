package Context;

import java.lang.annotation.*;
import Annotation.*;
import java.util.HashMap;
import java.util.Map;

public class Context {
    private static final Map<String, Object> beans = new HashMap<>();

    // public Context(String package) throws Exception{
    // scanAndInstanceBeans(package);
    // injectDependencies();
    // }
}
