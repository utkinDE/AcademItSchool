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
        double max = Math.max(range.from, from);
        double min = Math.min(range.to, to);

        if (max < min) {
            return new Range(max, min);
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
        double max = Math.max(range.from, from);
        double min = Math.min(range.to, to);

        if (max < min) {
            if (range.to <= min && range.from >= max) {
                return new Range[]{new Range(from, max), new Range(min, to)};
            }
            if (range.from >= max && range.to >= min) {
                return new Range[]{new Range(from, max)};
            }
            if (range.from <= max && range.to <= min) {
                return new Range[]{new Range(min, to)};
            }

            return new Range[]{};
        }

        return null;
    }
}