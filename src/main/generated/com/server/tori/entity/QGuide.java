package com.server.tori.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QGuide is a Querydsl query type for Guide
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGuide extends EntityPathBase<Guide> {

    private static final long serialVersionUID = -921608849L;

    public static final QGuide guide = new QGuide("guide");

    public final StringPath categori = createString("categori");

    public final StringPath course = createString("course");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath language = createString("language");

    public final StringPath price = createString("price");

    public final StringPath tripPoint = createString("tripPoint");

    public QGuide(String variable) {
        super(Guide.class, forVariable(variable));
    }

    public QGuide(Path<? extends Guide> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGuide(PathMetadata metadata) {
        super(Guide.class, metadata);
    }

}

