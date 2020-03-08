package utils;

public class hullFinder {
    point leftmost;
    window w;

    hullFinder(window _w) {
        w = _w;
        
    }

    int findLeftMost() {
        leftmost = w.points.get(w.points.size()-1);
        int i=0;
        for (point p : w.points) {
            if (p.x < leftmost.x) {
                leftmost = p;
                break;
            }
            i++;
        }
        return i;
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
        int numOfPoints = this.w.points.size();
        // 3 points have to be there.
        if(numOfPoints<3){
            throw new IllegalStateException("There must be 3 present points at least.");
        }
       
        // We clean the recent hull points we determined and we start anew.
        this.w.border.clear();
        int leftmostIndex =findLeftMost();
        int pointA,pointB;
        pointA = leftmostIndex;
        do{
            if(this.w.points.get(pointA)!=null)
            this.w.border.add(this.w.points.get(pointA));
            pointB = (pointA+1) % numOfPoints;
            for (int i = 0; i < numOfPoints;i++) {
                if (orientation(this.w.points.get(pointA),this.w.points.get(i), this.w.points.get(pointB)) 
                                                   == 2) 
                   pointB = i; 
            }
            pointA = pointB;
        }while(pointA != leftmostIndex);
    }

}