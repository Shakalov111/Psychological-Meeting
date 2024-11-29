package com.di;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;


public class PsychologistModule extends AbstractModule {
    @Override
    protected void configure() {
        // Прив'язка іменованої константи без власних залежностей
        bind(String.class)
            .annotatedWith(Names.named("Name"))
            .toInstance("polina");
    
        // альтернативний варіант прив'язки іменованої константи
        bindConstant()
            .annotatedWith(Names.named("Cost"))
            .to(2000.00);
    }


}