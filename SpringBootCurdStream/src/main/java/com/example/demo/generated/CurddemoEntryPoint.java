package com.example.demo.generated;

/**
 * The entry point for the {@link com.speedment.runtime.config.Project} named
 * curddemo
 * <p>
 * This file is safe to edit. It will not be overwritten by the code generator.
 * 
 * @author example
 */
public final class CurddemoEntryPoint {
    
    public static void main(String... args) {
        final CurddemoApplication application = new CurddemoApplicationBuilder()
            // Add bundles, auth information, etc.
            .build();
        
        // Application logic goes here
        
        application.stop();
    }
}