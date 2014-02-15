package org.bouncycastle.math.ec;

import java.math.BigInteger;

/**
 * Class for an elliptic curve over F_p^2
 */
public class ECCurveFp12 extends ECCurve {

    ECPoint infinity;

    BigInteger q;

    public ECCurveFp12(BigInteger q, ECFieldElementFp12 a, ECFieldElementFp12 b) {
	this.q = q;
	this.a = a;
	this.b = b;
	infinity = new ECPointFp12(this, null, null);
    }

    public ECCurveFp12(ECCurve.Fp c) {
	q = c.getQ();
	a = new ECFieldElementFp12((ECFieldElement.Fp) c.getA());
	b = new ECFieldElementFp12((ECFieldElement.Fp) (c.getB()));
	infinity = new ECPointFp12(this, null, null);
    }

    public ECCurveFp12(ECCurveFp2 c) {
	q = c.getQ();
	a = new ECFieldElementFp12((ECFieldElementFp2) c.getA(), 0);
	b = new ECFieldElementFp12((ECFieldElementFp2) (c.getB()), 0);
	infinity = new ECPointFp12(this, null, null);
    }

    public BigInteger getQ() {
	return q;
    }

    public int getFieldSize() {
	// number of bits of q^12
	return 12 * q.bitLength();
    }

    public ECFieldElement fromBigInteger(BigInteger x) {
	return new ECFieldElementFp12(new ECFieldElementFp2(q, x.divide(q
		.pow(10))), new ECFieldElementFp2(q, x.divide(q.pow(8))),
		new ECFieldElementFp2(q, x.divide(q.pow(6))),
		new ECFieldElementFp2(q, x.divide(q.pow(4))),
		new ECFieldElementFp2(q, x.divide(q.pow(2))),
		new ECFieldElementFp2(q, x), true);
    }

    public ECPoint createPoint(BigInteger x, BigInteger y,
	    boolean withCompression) {
	return null;
    }

    public ECPoint decodePoint(byte[] encoded) {
	return null;
    }

    public ECPoint getInfinity() {
	return infinity;
    }

    public boolean equals(Object o) {
	if (o == this) {
	    return true;
	}
	if (!(o instanceof ECCurveFp12)) {
	    return false;
	}
	ECCurveFp12 other = (ECCurveFp12) o;
	return q.equals(other.q) && a.equals(other.a) && b.equals(other.b);
    }

}
