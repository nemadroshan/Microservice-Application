package com.example.demo.generated.generated;

import com.example.demo.generated.CurddemoApplication;
import com.example.demo.generated.CurddemoApplicationBuilder;
import com.example.demo.generated.CurddemoApplicationImpl;
import com.example.demo.generated.CurddemoInjectorProxy;
import com.example.demo.generated.curddemo.curddemo.person.PersonManagerImpl;
import com.example.demo.generated.curddemo.curddemo.person.PersonSqlAdapter;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.common.injector.Injector;
import com.speedment.runtime.application.AbstractApplicationBuilder;
import com.speedment.runtime.connector.mysql.MySqlBundle;

/**
 * A generated base {@link
 * com.speedment.runtime.application.AbstractApplicationBuilder} class for the
 * {@link com.speedment.runtime.config.Project} named curddemo.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedCurddemoApplicationBuilder extends AbstractApplicationBuilder<CurddemoApplication, CurddemoApplicationBuilder> {
    
    protected GeneratedCurddemoApplicationBuilder() {
        super(CurddemoApplicationImpl.class, GeneratedCurddemoMetadata.class);
        withManager(PersonManagerImpl.class);
        withComponent(PersonSqlAdapter.class);
        withBundle(MySqlBundle.class);
        withInjectorProxy(new CurddemoInjectorProxy());
    }
    
    @Override
    public CurddemoApplication build(Injector injector) {
        return injector.getOrThrow(CurddemoApplication.class);
    }
}