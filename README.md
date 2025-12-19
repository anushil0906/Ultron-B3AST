# Ultron-B3AST
An android application to solve cryptography algorithms 


**RSA Algorithm in Cryptography**

RSA algorithm is an asymmetric cryptography algorithm. Asymmetric actually means that it works on two different keys i.e. Public Key and Private Key. As the name describes that the Public Key is given to everyone and the Private key is kept private.

An example of asymmetric cryptography: 

A client (for example browser) sends its public key to the server and requests some data.

The server encrypts the data using the client’s public key and sends the encrypted data.

The client receives this data and decrypts it.

Since this is asymmetric, nobody else except the browser can decrypt the data even if a third party has the public key of the browser.

**This application has 4 types of RSA decryption algorithms**

**ALGO1:** Classical RSA where modulus n is the multiplication of two large prime numbers p and q and public exponent (e-> 65537) and Euler's totient (ET-> (p-1)(q-1))
   and private exponent d = e^-1(mod(ET)). So the decryption message can be M = (C^d mod n), where C is the actual encryption in numeric form.

**ALGO2:** RSA decryption with the Chinese Remainder Theorem is an optimization of classic RSA. It is needed when n = p*q is very large and computation of C^d mod n is very slow. So, we use the Chinese Remainder        Theorem to break them into smaller modular exponents and then recombine. We compute dp = d mod (p-1), dq = d mod (q-1), where dp and dq are calculated from the previously computed d from classic RSA.
  Now we calculate (qinv = q^-1 mod p) to decrypt separately (m1 = C^dp mod p) and (m2 = C^dq mod q) and then combine it to calculate the original message.
  M = m2 + ((qinv * (m1-m2)) mod p) * q;

**ALGO3:** For RSA Common Modulo decryption when two users share the same n, but use different exponents e1 and e2. Then he used the Extended Euclidean Algorithm to find x and y from x*e1 + y*e2 = 1 and M (original     message) = (C1^x * C2^y) mod n. If x or y is negative, then he used modular inverse instead of normal exponentiation.

**ALGO4:** The cube root RSA works when m^3 < N and exponent e=3. So when c = m^e (mod N), c = m^3 (mod N), and if m^3 < N, then (original message) (m = e^1/3).



**The other cryptographic decryption algorithm it contain are for all kind of Base encoding,  esoteric programming language encodings and rotation ciphers.**
