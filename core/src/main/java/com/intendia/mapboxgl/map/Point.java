package com.intendia.mapboxgl.map;

import jsinterop.annotations.JsType;
import jsinterop.base.JsArrayLike;

/**
 * A <a href="https://github.com/mapbox/point-geometry">Point geometry</a> object, which has x and y properties
 * representing screen coordinates in pixels.
 */
@JsType(isNative = true)
public class Point {

    public double x, y;

    public Point(double x, double y) {}

    /** Clone this point, returning a new point that can be modified without affecting the old one. */
    public native Point clone();

    /** Add this point's [x, y] coordinates to another point, yielding a new point. */
    public native Point add(Point p);

    /** Subtract this point's [x, y] coordinates to from point, yielding a new point. */
    public native Point sub(Point p);

    /** Multiply this point's [x, y] coordinates by point, yielding a new point. */
    public native Point multByPoint(Point p);

    /** Divide this point's [x, y] coordinates by point, yielding a new point. */
    public native Point divByPoint(Point p);

    /** Multiply this point's [x, y] coordinates by a factor, yielding a new point. */
    public native Point mult(Point p);

    /** Divide this point's [x, y] coordinates by a factor, yielding a new point. */
    public native Point div(Point p);

    /** Rotate this point around the 0, 0 origin by an angle a, given in radians. */
    public native Point rotate(double angle);

    /** Rotate this point around p point by an angle a, given in radians. */
    public native Point rotateAround(double angle, Point center);

    /** Multiply this point by a 4x1 transformation matrix. */
    public native Point matMult(double[] transformationMatrix);

    /** Multiply this point by a 4x1 transformation matrix. */
    public native Point matMult(JsArrayLike<Double> transformationMatrix);

    /**
     * Calculate this point but as a unit vector from 0, 0, meaning that the distance from the resulting point to the 0,
     * 0 coordinate will be equal to 1 and the angle from the resulting point to the 0, 0 coordinate will be the same as
     * before.
     */
    public native Point unit();

    /**
     * Compute a perpendicular point, where the new y coordinate is the old x coordinate and the new x coordinate is the
     * old y coordinate multiplied by -1l
     */
    public native Point perp();

    /** Return a version of this point with the [x, y] coordinates rounded to integers. */
    public native Point round();

    /**
     * Return the magitude of this point: this is the Euclidean distance from the 0, 0 coordinate to this point's x and
     * y coordinates.
     */
    public native double mag();

    /** Judge whether this point is equal to another point, returning true or false. */
    public native boolean equals(Point other);

    /** Calculate the distance from this point to another pointl */
    public native double dist(Point p);

    /**
     * Calculate the distance from this point to another point, without the square root step. Useful if you're comparing
     * relative distances.
     */
    public native double distSqr(Point p);

    /** Get the angle from the 0, 0 coordinate to this point, in radians coordinates. */
    public native double angle();

    /** Get the angle from this point to another point, in radians. */
    public native double angleTo(Point p);

    /** Get the angle between this point and another point, in radians. */
    public native double angleWith(Point p);

    /** Find the angle of the two vectors, solving the formula for the cross product a x b = |a||b|sin(θ) for θ. */
    public native double angleWithStep(double x, double y);

    /**
     * Construct a point from an array if necessary, otherwise if the input is already a Point, or an unknown type,
     * return it unchanged.
     *
     * @param pointLike {@code (Array<Number>|Point)} any kind of input value
     */
    public static native Point convert(Object pointLike);
}
