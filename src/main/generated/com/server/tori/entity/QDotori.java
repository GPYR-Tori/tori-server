package com.server.tori.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDotori is a Querydsl query type for Dotori
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDotori extends EntityPathBase<Dotori> {

    private static final long serialVersionUID = 1403806954L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDotori dotori = new QDotori("dotori");

    public final DateTimePath<java.time.LocalDateTime> createDate = createDateTime("createDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QUser user;

    public QDotori(String variable) {
        this(Dotori.class, forVariable(variable), INITS);
    }

    public QDotori(Path<? extends Dotori> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDotori(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDotori(PathMetadata metadata, PathInits inits) {
        this(Dotori.class, metadata, inits);
    }

    public QDotori(Class<? extends Dotori> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

