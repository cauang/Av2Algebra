package src;
public class LinearTransformations {

    /* Conversões entre sistemas de coordenadas */
    private static double[] toHomogeneous2D(double[] v) {
        return new double[]{v[0], v[1], 1};
    }
    
    private static double[] toHomogeneous3D(double[] v) {
        return new double[]{v[0], v[1], v[2], 1};
    }
    
    private static double[] toCartesian2D(double[] v) {
        return new double[]{v[0]/v[2], v[1]/v[2]};
    }
    
    private static double[] toCartesian3D(double[] v) {
        return new double[]{v[0]/v[3], v[1]/v[3], v[2]/v[3]};
    }
    
    /* Operações matriciais */
    private static double[] multiplyMatrix2D(double[][] m, double[] v) {
        return new double[]{
            m[0][0]*v[0] + m[0][1]*v[1] + m[0][2]*v[2],
            m[1][0]*v[0] + m[1][1]*v[1] + m[1][2]*v[2],
            m[2][0]*v[0] + m[2][1]*v[1] + m[2][2]*v[2]
        };
    }
    
    private static double[] multiplyMatrix3D(double[][] m, double[] v) {
        return new double[]{
            m[0][0]*v[0] + m[0][1]*v[1] + m[0][2]*v[2] + m[0][3]*v[3],
            m[1][0]*v[0] + m[1][1]*v[1] + m[1][2]*v[2] + m[1][3]*v[3],
            m[2][0]*v[0] + m[2][1]*v[1] + m[2][2]*v[2] + m[2][3]*v[3],
            m[3][0]*v[0] + m[3][1]*v[1] + m[3][2]*v[2] + m[3][3]*v[3]
        };
    }
    
    /* Transformações 2D */
    public static Vector translate2D(Vector v, double dx, double dy) {
        double[] vec = {v.getElement(0), v.getElement(1)};
        double[] homo = toHomogeneous2D(vec);
        double[][] m = {
            {1, 0, dx},
            {0, 1, dy},
            {0, 0, 1}
        };
        return new Vector(toCartesian2D(multiplyMatrix2D(m, homo)));
    }
    
    public static Vector rotation2D(Vector v, double angle) {
        double[] vec = {v.getElement(0), v.getElement(1)};
        double[] homo = toHomogeneous2D(vec);
        double c = Math.cos(angle);
        double s = Math.sin(angle);
        double[][] m = {
            {c, -s, 0},
            {s, c, 0},
            {0, 0, 1}
        };
        return new Vector(toCartesian2D(multiplyMatrix2D(m, homo)));
    }
    
    public static Vector reflection2DX(Vector v) {
        double[] vec = {v.getElement(0), v.getElement(1)};
        double[] homo = toHomogeneous2D(vec);
        double[][] m = {
            {1, 0, 0},
            {0, -1, 0},
            {0, 0, 1}
        };
        return new Vector(toCartesian2D(multiplyMatrix2D(m, homo)));
    }
    
    public static Vector reflection2DY(Vector v) {
        double[] vec = {v.getElement(0), v.getElement(1)};
        double[] homo = toHomogeneous2D(vec);
        double[][] m = {
            {-1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
        return new Vector(toCartesian2D(multiplyMatrix2D(m, homo)));
    }
    
    public static Vector projection2DX(Vector v) {
        double[] vec = {v.getElement(0), v.getElement(1)};
        double[] homo = toHomogeneous2D(vec);
        double[][] m = {
            {1, 0, 0},
            {0, 0, 0},
            {0, 0, 1}
        };
        return new Vector(toCartesian2D(multiplyMatrix2D(m, homo)));
    }
    
    public static Vector projection2DY(Vector v) {
        double[] vec = {v.getElement(0), v.getElement(1)};
        double[] homo = toHomogeneous2D(vec);
        double[][] m = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
        return new Vector(toCartesian2D(multiplyMatrix2D(m, homo)));
    }
    
    public static Vector shearing2D(Vector v, double kx, double ky) {
        double[] vec = {v.getElement(0), v.getElement(1)};
        double[] homo = toHomogeneous2D(vec);
        double[][] m = {
            {1, kx, 0},
            {ky, 1, 0},
            {0, 0, 1}
        };
        return new Vector(toCartesian2D(multiplyMatrix2D(m, homo)));
    }
    
    /* Transformações 3D */
    public static Vector translate3D(Vector v, double dx, double dy, double dz) {
        double[] vec = {v.getElement(0), v.getElement(1), v.getElement(2)};
        double[] homo = toHomogeneous3D(vec);
        double[][] m = {
            {1, 0, 0, dx},
            {0, 1, 0, dy},
            {0, 0, 1, dz},
            {0, 0, 0, 1}
        };
        return new Vector(toCartesian3D(multiplyMatrix3D(m, homo)));
    }
    
    public static Vector rotation3DX(Vector v, double angle) {
        double[] vec = {v.getElement(0), v.getElement(1), v.getElement(2)};
        double[] homo = toHomogeneous3D(vec);
        double c = Math.cos(angle);
        double s = Math.sin(angle);
        double[][] m = {
            {1, 0, 0, 0},
            {0, c, -s, 0},
            {0, s, c, 0},
            {0, 0, 0, 1}
        };
        return new Vector(toCartesian3D(multiplyMatrix3D(m, homo)));
    }
    
    public static Vector rotation3DY(Vector v, double angle) {
        double[] vec = {v.getElement(0), v.getElement(1), v.getElement(2)};
        double[] homo = toHomogeneous3D(vec);
        double c = Math.cos(angle);
        double s = Math.sin(angle);
        double[][] m = {
            {c, 0, s, 0},
            {0, 1, 0, 0},
            {-s, 0, c, 0},
            {0, 0, 0, 1}
        };
        return new Vector(toCartesian3D(multiplyMatrix3D(m, homo)));
    }
    
    public static Vector rotation3DZ(Vector v, double angle) {
        double[] vec = {v.getElement(0), v.getElement(1), v.getElement(2)};
        double[] homo = toHomogeneous3D(vec);
        double c = Math.cos(angle);
        double s = Math.sin(angle);
        double[][] m = {
            {c, -s, 0, 0},
            {s, c, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };
        return new Vector(toCartesian3D(multiplyMatrix3D(m, homo)));
    }
    
    public static Vector reflection3DX(Vector v) {
        double[] vec = {v.getElement(0), v.getElement(1), v.getElement(2)};
        double[] homo = toHomogeneous3D(vec);
        double[][] m = {
            {1, 0, 0, 0},
            {0, -1, 0, 0},
            {0, 0, -1, 0},
            {0, 0, 0, 1}
        };
        return new Vector(toCartesian3D(multiplyMatrix3D(m, homo)));
    }
    
    public static Vector reflection3DY(Vector v) {
        double[] vec = {v.getElement(0), v.getElement(1), v.getElement(2)};
        double[] homo = toHomogeneous3D(vec);
        double[][] m = {
            {-1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, -1, 0},
            {0, 0, 0, 1}
        };
        return new Vector(toCartesian3D(multiplyMatrix3D(m, homo)));
    }
    
    public static Vector reflection3DZ(Vector v) {
        double[] vec = {v.getElement(0), v.getElement(1), v.getElement(2)};
        double[] homo = toHomogeneous3D(vec);
        double[][] m = {
            {-1, 0, 0, 0},
            {0, -1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };
        return new Vector(toCartesian3D(multiplyMatrix3D(m, homo)));
    }
    
    public static Vector projection3DX(Vector v) {
        double[] vec = {v.getElement(0), v.getElement(1), v.getElement(2)};
        double[] homo = toHomogeneous3D(vec);
        double[][] m = {
            {1, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 1}
        };
        return new Vector(toCartesian3D(multiplyMatrix3D(m, homo)));
    }
    
    public static Vector projection3DY(Vector v) {
        double[] vec = {v.getElement(0), v.getElement(1), v.getElement(2)};
        double[] homo = toHomogeneous3D(vec);
        double[][] m = {
            {0, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 1}
        };
        return new Vector(toCartesian3D(multiplyMatrix3D(m, homo)));
    }
    
    public static Vector projection3DZ(Vector v) {
        double[] vec = {v.getElement(0), v.getElement(1), v.getElement(2)};
        double[] homo = toHomogeneous3D(vec);
        double[][] m = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };
        return new Vector(toCartesian3D(multiplyMatrix3D(m, homo)));
    }
}