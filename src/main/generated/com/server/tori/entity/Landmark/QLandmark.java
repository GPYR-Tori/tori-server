package com.server.tori.entity.Landmark;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLandmark is a Querydsl query type for Landmark
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLandmark extends EntityPathBase<Landmark> {

    private static final long serialVersionUID = 2142208833L;

    public static final QLandmark landmark = new QLandmark("landmark");

    public final ListPath<Category, QCategory> categoryList = this.<Category, QCategory>createList("categoryList", Category.class, QCategory.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<Image, QImage> imageList = this.<Image, QImage>createList("imageList", Image.class, QImage.class, PathInits.DIRECT2);

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final ListPath<Location, QLocation> locationList = this.<Location, QLocation>createList("locationList", Location.class, QLocation.class, PathInits.DIRECT2);

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    public final StringPath phoneNum = createString("phoneNum");

    public final StringPath price = createString("price");

    public final StringPath site = createString("site");

    public final StringPath time = createString("time");

    public final ListPath<Translation, QTranslation> translationList = this.<Translation, QTranslation>createList("translationList", Translation.class, QTranslation.class, PathInits.DIRECT2);

    public QLandmark(String variable) {
        super(Landmark.class, forVariable(variable));
    }

    public QLandmark(Path<? extends Landmark> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLandmark(PathMetadata metadata) {
        super(Landmark.class, metadata);
    }

}

