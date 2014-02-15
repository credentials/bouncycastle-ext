package org.bouncycastle.math.ec;

import java.math.BigInteger;

/**
 * Class for an elliptic curve over F_p^2
 */
public class ECCurveFp2 extends ECCurve {
    ECPoint infinity;

    public ECPoint getInfinity() {
	return infinity;
    }

    BigInteger q;

    public ECCurveFp2(BigInteger q, ECFieldElementFp2 a, ECFieldElementFp2 b) {
	this.q = q;
	this.a = a;
	this.b = b;
	infinity = new ECPointFp2(this, null, null);
    }

    public ECCurveFp2(ECCurve.Fp c) {
	q = c.getQ();
	a = new ECFieldElementFp2((ECFieldElement.Fp) c.getA());
	b = new ECFieldElementFp2((ECFieldElement.Fp) (c.getB()));
	infinity = new ECPointFp2(this, null, null);
    }

    public BigInteger getQ() {
	return q;
    }

    public int getFieldSize() {
	// number of bits of q^2
	return 2 * q.bitLength();
    }

    public ECFieldElement fromBigInteger(BigInteger x) {
	return new ECFieldElementFp2(q, x);
    }

    public ECPoint createPoint(BigInteger x, BigInteger y,
	    boolean withCompression) {
	return null;
    }

    public ECPoint decodePoint(byte[] encoded) {
	return null;
    }

    public boolean equals(Object o) {
	if (o == this) {
	    return true;
	}
	if (!(o instanceof ECCurveFp2)) {
	    return false;
	}
	ECCurveFp2 other = (ECCurveFp2) o;
	return q.equals(other.q) && a.equals(other.a) && b.equals(other.b);
    }

}
