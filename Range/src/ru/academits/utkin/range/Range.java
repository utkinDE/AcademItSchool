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

    public double getRangeLength() {
        return Math.abs(from - to);
    }

    public boolean isInside(double number) {
        return !(number < from) && !(number > to);
    }

    public Range getRangeIntersection(Range range) {
        if (range.from <= this.to && range.to >= this.from) {
            if (this.from >= range.from && this.to <= range.to) {
                return new Range(this.from, this.to);
            } else if (this.from >= range.from && this.to >= range.to) {
                return new Range(this.from, range.to);
            } else if (this.from <= range.from && this.to <= range.to) {
                return new Range(range.from, this.to);
            } else if (this.from <= range.from && this.to >= range.to) {
                return new Range(range.from, range.to);
            }
        }

        return null;
    }

    public Range[] getRangeUnion(Range range) {
        if (range.from <= this.to && range.to >= this.from) {
            double minFrom = Math.min(range.from, this.from);
            double minTo = Math.min(range.to, this.to);
            double smallest = Math.min(minFrom, minTo);

            double maxFrom = Math.max(range.from, this.from);
            double maxTo = Math.max(range.to, this.to);
            double largest = Math.max(maxFrom, maxTo);

            Range[] rangesArray = new Range[1];
            rangesArray[0] = new Range(smallest, largest);

            return rangesArray;
        } else {
            Range[] rangesArray = new Range[2];
            rangesArray[0] = new Range(range.from, range.to);
            rangesArray[1] = new Range(this.from, this.to);

            return rangesArray;
        }
    }

    public Range[] getRangeRemainder(Range range) {
        if (range.from <= this.to && range.to >= this.from) {
            if (this.from > range.from && this.to < range.to) {
                Range[] rangesArray = new Range[2];
                rangesArray[0] = new Range(range.from, this.from);
                rangesArray[1] = new Range(this.to, range.to);

                return rangesArray;
            } else if (this.from > range.from && this.to > range.to) {
                Range[] rangesArray = new Range[1];
                rangesArray[0] = new Range(range.from, this.from);

                return rangesArray;
            } else if (this.from < range.from && this.to < range.to) {
                Range[] rangesArray = new Range[1];
                rangesArray[0] = new Range(this.to, range.to);

                return rangesArray;
            } else if (this.from < range.from && this.to > range.to) {
                return new Range[0];
            } else if (this.from == range.from && range.to == this.to) {
                return new Range[3]; // Здесь длина массива 3 имеет смысл метки для вывода.
            }
        }
        return null;
    }
}