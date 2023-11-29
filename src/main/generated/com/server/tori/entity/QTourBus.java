package com.server.tori.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTourBus is a Querydsl query type for TourBus
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTourBus extends EntityPathBase<TourBus> {

    private static final long serialVersionUID = 1884466875L;

    public static final QTourBus tourBus = new QTourBus("tourBus");

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath language = createString("language");

    public QTourBus(String variable) {
        super(TourBus.class, forVariable(variable));
    }

    public QTourBus(Path<? extends TourBus> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTourBus(PathMetadata metadata) {
        super(TourBus.class, metadata);
    }

}

