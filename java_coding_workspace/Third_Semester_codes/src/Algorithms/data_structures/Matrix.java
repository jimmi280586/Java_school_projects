package data_structures;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;

/**
 * Matrx. This Matrix implementation is designed to be more efficient
 * in cache. A matrix is a rectangular array of numbers, symbols, or expressions.
 *
 * http://en.wikipedia.org/wiki/Matrix_(mathematics)
 *
 * @author Justin Wetherell <phishman3579@gmail.com>
 */
public class Matrix<T extends Number> {

    private int rows = 0;
    private int cols = 0;
    private T[] matrix = null;

    private final Comparator<T> comparator = new Comparator<T>() {
        /**
         * {@inheritDoc}
         */
        @Override
        public int compare(T o1, T o2) {
            /* TODO: What if Java adds new numberic type? */
            int result = 0;
            if (o1 instanceof BigDecimal || o2 instanceof BigDecimal) {
                BigDecimal c1 = (BigDecimal)o1;
                BigDecimal c2 = (BigDecimal)o2;
                result = c1.compareTo(c2);
            } else if (o1 instanceof BigInteger || o2 instanceof BigInteger) {
                BigInteger c1 = (BigInteger)o1;
                BigInteger c2 = (BigInteger)o2;
                result = c1.compareTo(c2);
            } else if (o1 instanceof Long || o2 instanceof Long) {
                Long c1 = o1.longValue();
                Long c2 = o2.longValue();
                result = c1.compareTo(c2);
            } else if (o1 instanceof Double || o2 instanceof Double) {
                Double c1 = o1.doubleValue();
                Double c2 = o2.doubleValue();
                result = c1.compareTo(c2);
            } else if (o1 instanceof Float || o2 instanceof Float) {
                Float c1 = o1.floatValue();
                Float c2 = o2.floatValue();
                result = c1.compareTo(c2);
            } else {
                Integer c1 = o1.intValue();
                Integer c2 = o2.intValue();
                result = c1.compareTo(c2);
            }
            return result;
        }
    };

    /**
     * Matrix with 'rows' number of rows and 'cols' number of columns.
     *
     * @param rows Number of rows in Matrix.
     * @param cols Number of columns in Matrix.
     */
    @SuppressWarnings("unchecked")
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = (T[]) new Number[rows * cols];
    }

    /**
     * Matrix with 'rows' number of rows and 'cols' number of columns, populates
     * the double index matrix.
     *
     * @param rows Number of rows in Matrix.
     * @param cols Number of columns in Matrix.
     * @param matrix 2D matrix used to populate Matrix.
     */
    @SuppressWarnings("unchecked")
    public Matrix(int rows, int cols, T[][] matrix) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = (T[]) new Number[rows * cols];
        for (int r=0; r<rows; r++)
            for (int c=0; c<cols; c++)
                this.matrix[getIndex(r,c)] = matrix[r][c];
    }

    private int getIndex(int row, int col) {
        if (row == 0)
            return col;
        return ((row * cols) + col);
    }

    public T get(int row, int col) {
        return matrix[getIndex(row, col)];
    }

    @SuppressWarnings("unchecked")
    public T[] getRow(int row) {
        T[] result = (T[]) new Number[cols];
        for (int c = 0; c < cols; c++) {
            result[c] = this.get(row, c);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public T[] getColumn(int col) {
        T[] result = (T[]) new Number[rows];
        for (int r = 0; r < rows; r++) {
            result[r] = this.get(r, col);
        }
        return result;
    }

    public void set(int row, int col, T value) {
        matrix[getIndex(row, col)] = value;
    }

    @SuppressWarnings("unchecked")
    public Matrix<T> add(Matrix<T> input) {
        Matrix<T> output = new Matrix<T>(this.rows, this.cols);
        if ((this.cols != input.cols) || (this.rows != input.rows))
            return output;

        for (int r = 0; r < output.rows; r++) {
            for (int c = 0; c < output.cols; c++) {
                for (int i = 0; i < cols; i++) {
                    T m1 = this.get(r, c);
                    T m2 = input.get(r, c);
                    T result;
                    /* TODO: This is ugly and how to handle number overflow? */
                    if (m1 instanceof BigDecimal || m2 instanceof BigDecimal) {
                        BigDecimal result2 = ((BigDecimal)m1).add((BigDecimal)m2);
                        result = (T)result2;
                    } else if (m1 instanceof BigInteger || m2 instanceof BigInteger) {
                        BigInteger result2 = ((BigInteger)m1).add((BigInteger)m2);
                        result = (T)result2;
                    } else if (m1 instanceof Long || m2 instanceof Long) {
                        Long result2 = (m1.longValue() + m2.longValue());
                        result = (T)result2;
                    } else if (m1 instanceof Double || m2 instanceof Double) {
                        Double result2 = (m1.doubleValue() + m2.doubleValue());
                        result = (T)result2;
                    } else if (m1 instanceof Float || m2 instanceof Float) {
                        Float result2 = (m1.floatValue() + m2.floatValue());
                        result = (T)result2;
                    } else {
                        // Integer
                        Integer result2 = (m1.intValue() + m2.intValue());
                        result = (T)result2;
                    }
                    output.set(r, c, result);
                }
            }
        }
        return output;
    }

    @SuppressWarnings("unchecked")
    public Matrix<T> subtract(Matrix<T> input) {
        Matrix<T> output = new Matrix<T>(this.rows, this.cols);
        if ((this.cols != input.cols) || (this.rows != input.rows))
            return output;

        for (int r = 0; r < output.rows; r++) {
            for (int c = 0; c < output.cols; c++) {
                for (int i = 0; i < cols; i++) {
                    T m1 = this.get(r, c);
                    T m2 = input.get(r, c);
                    T result;
                    /* TODO: This is ugly and how to handle number overflow? */
                    if (m1 instanceof BigDecimal || m2 instanceof BigDecimal) {
                        BigDecimal result2 = ((BigDecimal)m1).subtract((BigDecimal)m2);
                        result = (T)result2;
                    } else if (m1 instanceof BigInteger || m2 instanceof BigInteger) {
                        BigInteger result2 = ((BigInteger)m1).subtract((BigInteger)m2);
                        result = (T)result2;
                    } else if (m1 instanceof Long || m2 instanceof Long) {
                        Long result2 = (m1.longValue() - m2.longValue());
                        result = (T)result2;
                    } else if (m1 instanceof Double || m2 instanceof Double) {
                        Double result2 = (m1.doubleValue() - m2.doubleValue());
                        result = (T)result2;
                    } else if (m1 instanceof Float || m2 instanceof Float) {
                        Float result2 = (m1.floatValue() - m2.floatValue());
                        result = (T)result2;
                    } else {
                        // Integer
                        Integer result2 = (m1.intValue() - m2.intValue());
                        result = (T)result2;
                    }
                    output.set(r, c, result);
                }
            }
        }
        return output;
    }

    @SuppressWarnings("unchecked")
    public Matrix<T> multiply(Matrix<T> input) {
        Matrix<T> output = new Matrix<T>(this.rows, input.cols);
        if (this.cols != input.rows)
            return output;

        for (int r = 0; r < output.rows; r++) {
            for (int c = 0; c < output.cols; c++) {
                T[] row = getRow(r);
                T[] column = input.getColumn(c);
                T test = row[0];
                /* TODO: This is ugly and how to handle number overflow? */
                if (test instanceof BigDecimal) {
                    BigDecimal result = BigDecimal.ZERO;
                    for (int i = 0; i < cols; i++) {
                        T m1 = row[i];
                        T m2 = column[i];

                        BigDecimal result2 = ((BigDecimal)m1).multiply(((BigDecimal)m2));
                        result.add(result2);
                    }
                    output.set(r, c, (T)result);
                } else if (test instanceof BigInteger) {
                    BigInteger result = BigInteger.ZERO;
                    for (int i = 0; i < cols; i++) {
                        T m1 = row[i];
                        T m2 = column[i];

                        BigInteger result2 = ((BigInteger)m1).multiply(((BigInteger)m2));
                        result.add(result2);
                    }
                    output.set(r, c, (T)result);
                } else if (test instanceof Long) {
                    Long result = 0l;
                    for (int i = 0; i < cols; i++) {
                        T m1 = row[i];
                        T m2 = column[i];

                        Long result2 = m1.longValue() * m2.longValue();
                        result = result+result2;
                    }
                    output.set(r, c, (T)result);
                } else if (test instanceof Double) {
                    Double result = 0d;
                    for (int i = 0; i < cols; i++) {
                        T m1 = row[i];
                        T m2 = column[i];

                        Double result2 = m1.doubleValue() * m2.doubleValue();
                        result = result+result2;
                    }
                    output.set(r, c, (T)result);
                } else if (test instanceof Float) {
                    Float result = 0f;
                    for (int i = 0; i < cols; i++) {
                        T m1 = row[i];
                        T m2 = column[i];

                        Float result2 = m1.floatValue() * m2.floatValue();
                        result = result+result2;
                    }
                    output.set(r, c, (T)result);
                } else {
                    // Integer
                    Integer result = 0;
                    for (int i = 0; i < cols; i++) {
                        T m1 = row[i];
                        T m2 = column[i];

                        Integer result2 = m1.intValue() * m2.intValue();
                        result = result+result2;
                    }
                    output.set(r, c, (T)result);
                }
            }
        }
        return output;
    }

    public void copy(Matrix<T> m) {
        for (int r = 0; r < m.rows; r++) {
            for (int c = 0; c < m.cols; c++) {
                set(r, c, m.get(r, c));
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = this.rows + this.cols;
        for (T t : matrix)
            hash += t.intValue();
        return 31 * hash;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Matrix))
            return false;

        Matrix<T> m = (Matrix<T>) obj;
        if (this.rows != m.rows)
            return false;
        if (this.cols != m.cols)
            return false;
        for (int i=0; i<matrix.length; i++) {
            T t1 = matrix[i];
            T t2 = m.matrix[i];
            int result = comparator.compare(t1, t2);
            if (result!=0)
                return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Matrix:\n");
        for (int r = 0; r < rows; r++) {
            builder.append("row=[").append(r).append("] ");
            for (int c = 0; c < cols; c++) {
                builder.append(this.get(r, c)).append("\t");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
