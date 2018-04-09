package hhshss;

import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.cms.SignerInformationStore;
import org.bouncycastle.cms.jcajce.JcaSimpleSignerInfoVerifierBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Store;

public class SignDataVerificationUtil {

	private static final String BC = "BC";
	private static final String UTF8 = "UTF8";
	static {
		Security.addProvider(new BouncyCastleProvider());
	}
	

	/**
	 * This method takes input of base64Encoded data and base64SignedData
	 * 
	 * @param base64Data
	 *            base64SignedData
	 * @return boolean- true or false
	 * @throws Exception
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public static boolean verifySign_nsdl(String base64Data,
			String base64SignedData) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		boolean verifiedStatus = false;
		CMSSignedData cmsSignedData = null;
		try {
			byte[] signedBytes = Base64
					.decodeBase64(base64SignedData.getBytes(UTF8));
			
			cmsSignedData = new CMSSignedData(
					new CMSProcessableByteArray(base64Data.getBytes(UTF8)),
					signedBytes);
			Store certStore = cmsSignedData.getCertificates();
			SignerInformationStore signers = cmsSignedData.getSignerInfos();
			Iterator signersIterator = signers.getSigners().iterator();
			while (signersIterator.hasNext()) {
				SignerInformation signer = (SignerInformation) signersIterator
						.next();
				Collection certCollection = certStore
						.getMatches(signer.getSID());
				Iterator certIt = certCollection.iterator();
				X509CertificateHolder certHolder = (X509CertificateHolder) certIt
						.next();
				X509Certificate x509Certificate = new JcaX509CertificateConverter()
						.setProvider(BC).getCertificate(certHolder);
				verifiedStatus = signer
						.verify(new JcaSimpleSignerInfoVerifierBuilder()
								.setProvider(BC).build(x509Certificate));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
		return verifiedStatus;
	}

}
