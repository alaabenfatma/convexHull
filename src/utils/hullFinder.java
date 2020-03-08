package utils;

public class hullFinder {
    point leftmost;
    window w;

    hullFinder(window _w) {
        w = _w;
        leftmost = w.points.get(0);
    }

    void findLeftMost() {
        for (point p : w.points) {
            if (p.x < leftmost.x) {
                leftmost = p;
            }
        }
    }

    int orientation(point p, point q, point r) {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        switch (val) {
            case 0:
                return 0;
            default:
                if (val > 0) {
                    return 1;
                } else {
                    return 2;
                }
        }
    }

    void findHull() {
        // 3 points have to be there.
        if(this.w.points.size()<3){
            throw new IllegalStateException("There must be 3 present points at least.");
        }
        // We clean the recent hull points we determined and we start anew.
        this.w.border.clear();

    }

}