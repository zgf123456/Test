package com.zgf.Test.aligorthm.aStar;

import java.util.ArrayList;
import java.util.List;

public class AGame {
    // 规则-上下左右移动,移动cost=10
    // F = G(开始节点到当前节点的花费) + H(当前节点到结束节点的花费)

    private AMap aMap;
    private APoint startPoint;
    private APoint endPoint;

    private List<APointWrap> openPoints = new ArrayList<>(); // 开启节点列表
    private List<APointWrap> closePoints = new ArrayList<>(); // 关闭节点列表

    public AMap getaMap() {
        return aMap;
    }

    public void setaMap(AMap aMap) {
        this.aMap = aMap;
    }

    public APoint getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(APoint startPoint) {
        this.startPoint = startPoint;
    }

    public APoint getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(APoint endPoint) {
        this.endPoint = endPoint;
    }

    public void printAMap() {
        this.printAMap(null);
    }

    public void printAMap(List<APoint> paths) {
        for (int i = 0; i < aMap.getHeight(); i++) {
            for (int j = 0; j < aMap.getWight(); j++) {
                APoint point = aMap.getPoint(j, i);
                if (point.getStatus() == 0) {
                    if (paths != null) {
                        if (paths.contains(point)) {
                            System.out.print("1");
                        } else {
                            System.out.print("0");
                        }
                    } else {
                        System.out.print("0");
                    }
                } else if (point.getStatus() < 0) {
                    System.out.print("#");
                } else if (point.getStatus() == 1) {
                    System.out.print("S");
                } else if (point.getStatus() == 9) {
                    System.out.print("E");
                } else {
                    System.out.print(point.getStatus());
                }
            }
            System.out.println();
        }

    }

    public APointWrap isOpen(APoint aPoint) {
        for (APointWrap pw : openPoints) {
            if (pw.getaPoint().equals(aPoint)) {
                return pw;
            }
        }
        return null;
    }

    public boolean isClose(APoint aPoint) {
        for (APointWrap pw : closePoints) {
            if (pw.getaPoint().equals(aPoint)) {
                return true;
            }
        }
        return false;
    }

    public void openPoint(APointWrap aPointWarp) {
        openPoints.add(aPointWarp);
    }

    public int countHCost(APoint aPoint) {
        APoint endPoint = this.getEndPoint();
        return Math.abs(endPoint.getX() - aPoint.getX()) + Math.abs(endPoint.getY() - aPoint.getY());
    }

    public List<APointWrap> getOpenPoints() {
        return openPoints;
    }

    public List<APointWrap> getClosePoints() {
        return closePoints;
    }

    private List<APoint> getNeibours(APointWrap minCost) {
        ArrayList<APoint> aPoints = new ArrayList<>();
        APoint aPoint = minCost.getaPoint();
        if (aPoint.getX() - 1 >= 0) {
            aPoints.add(aMap.getPoint(aPoint.getX() - 1, aPoint.getY()));
        }
        if (aPoint.getX() + 1 < aMap.getWight()) {
            aPoints.add(aMap.getPoint(aPoint.getX() + 1, aPoint.getY()));
        }
        if (aPoint.getY() - 1 >= 0) {
            aPoints.add(aMap.getPoint(aPoint.getX(), aPoint.getY() - 1));
        }
        if (aPoint.getY() + 1 < aMap.getHeight()) {
            aPoints.add(aMap.getPoint(aPoint.getX(), aPoint.getY() + 1));
        }
        return aPoints;
    }

    /**
     * 开始寻路
     */
    public static void startFindPath(AGame aGame) {
        APoint startPoint = aGame.getStartPoint();
        APointWrap aPointWrapStart = new APointWrap(startPoint, null);
        aPointWrapStart.setCostG(0);
        aPointWrapStart.setCostH(aGame.countHCost(startPoint));
        aPointWrapStart.setCostF(aPointWrapStart.getCostG() + aPointWrapStart.getCostH());
        aGame.openPoint(aPointWrapStart);

        // 开始寻路
        APointWrap currentPoint = null;
        boolean result = false;
        while (true) {
            APointWrap minCost = null;

            List<APointWrap> openPoints = aGame.getOpenPoints();
            List<APointWrap> closePoints = aGame.getClosePoints();
            for (APointWrap wrap : openPoints) {
                if (minCost == null) {
                    minCost = wrap;
                } else if (wrap.getCostF() < minCost.getCostF()) {
                    minCost = wrap;
                }
            }

            if (minCost == null) {
                System.out.println("find fail .......");
                break;
            }

            openPoints.remove(minCost);
            closePoints.add(minCost);
            if (currentPoint == null) {
                currentPoint = minCost;
            } else {
                minCost.setParentPoint(currentPoint);
            }

            // 获取相邻节点，加入打开节点
            List<APoint> neibours = aGame.getNeibours(minCost);
            if (neibours.size() > 0) {
                if (neibours.contains(aGame.getEndPoint())) {
                    System.out.println("find end point, success .......");
                    result = true;
                    break;
                }

                for (APoint aPoint : neibours) {
                    if (aPoint.getStatus() < 0 || aGame.isClose(aPoint)) {
                        // do nothing
                    } else {
                        APointWrap open = aGame.isOpen(aPoint);
                        if (open != null) {
                            // 路径校正
                            int costG = minCost.getCostG() + 10;
                            if (costG < open.getCostG()) {
                                open.setParentPoint(minCost);
                                open.setCostG(costG);
                                open.setCostH(aGame.countHCost(aPoint));
                                open.setCostF(open.getCostG() + open.getCostH());
                            }
                        } else {
                            // 添加路径
                            APointWrap wrap = new APointWrap(aPoint, minCost);
                            wrap.setCostG(minCost.getCostG() + 10);
                            wrap.setCostH(aGame.countHCost(aPoint));
                            wrap.setCostF(wrap.getCostG() + wrap.getCostH());
                            openPoints.add(wrap);
                        }
                    }
                }
            }
        }

        if (result) {
            List<APoint> shortPath = new ArrayList<>();
            shortPath.add(currentPoint.getaPoint());
            while (currentPoint.getParentPoint() != null) {
                currentPoint = currentPoint.getParentPoint();
                shortPath.add(currentPoint.getaPoint());
            }
            System.out.println("game success....");
            aGame.printAMap(shortPath);
        } else {
            System.out.println("game fail....");
            List<APointWrap> closePoints = aGame.getClosePoints();
            List<APoint> findPath = new ArrayList<>();
            for (APointWrap cp : closePoints) {
                findPath.add(cp.getaPoint());
            }
            aGame.printAMap(findPath);
        }
    }
}
