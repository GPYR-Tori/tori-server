package com.server.tori.entity.Landmark;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTranslation is a Querydsl query type for Translation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTranslation extends EntityPathBase<Translation> {

    private static final long serialVersionUID = -1607192056L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTranslation translation = new QTranslation("translation");

    public final StringPath address = createString("address");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QLandmark landmark;

    public final StringPath language = createString("language");

    public final StringPath name = createString("name");

    public QTranslation(String variable) {
        this(Translation.class, forVariable(variable), INITS);
    }

    public QTranslation(Path<? extends Translation> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTranslation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTranslation(PathMetadata metadata, PathInits inits) {
        this(Translation.class, metadata, inits);
    }

    public QTranslation(Class<? extends Translation> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.landmark = inits.isInitialized("landmark") ? new QLandmark(forProperty("landmark")) : null;
    }

}

