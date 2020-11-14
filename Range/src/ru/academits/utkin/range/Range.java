package ru.academits.utkin.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;           // from  > to (always)
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getIntersection(Range range) {
        double maxFrom = Math.max(range.from, from);
        double minTo = Math.min(range.to, to);

        if (maxFrom < minTo) {
            return new Range(maxFrom, minTo);
        }

        return null;
    }

    public Range[] getUnion(Range range) {
        if (range.from <= to && range.to >= from) {
            double minFrom = Math.min(range.from, from);
            double maxTo = Math.max(range.to, to);

            return new Range[]{new Range(minFrom, maxTo)};
        }

        return new Range[]{new Range(range.from, range.to), new Range(from, to)};
    }

    public Range[] getDifference(Range range) {
        if (range.from > to || from > range.to) {
            return new Range[]{new Range(from, to)};
        }
        if (from < range.from && to > range.to) {
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        }
        if (from >= range.from && to <= range.to) {
            return new Range[]{};
        }
        if (from <= range.from && to <= range.to) {
            return new Range[]{new Range(from, range.from)};
        }

        return new Range[]{new Range(range.to, to)};
    }

    public void print() {
        System.out.printf("(%.2f, %.2f)", from, to);
    }
}