/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.tls.protocol.parser;

import de.rub.nds.tlsattacker.tls.constants.HandshakeByteLength;
import de.rub.nds.tlsattacker.tls.constants.HandshakeMessageType;
import de.rub.nds.tlsattacker.tls.constants.ProtocolVersion;
import de.rub.nds.tlsattacker.tls.protocol.message.CertificateMessage;
import de.rub.nds.tlsattacker.util.ArrayConverter;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Robert Merget - robert.merget@rub.de
 */
public class CertificateMessageParser extends HandshakeMessageParser<CertificateMessage> {

    /**
     * Constructor for the Parser class
     *
     * @param startposition
     *            Position in the array where the HandshakeMessageParser is
     *            supposed to start parsing
     * @param array
     *            The byte[] which the HandshakeMessageParser is supposed to
     *            parse
     * @param version
     *            Version of the Protocol
     */
    public CertificateMessageParser(int startposition, byte[] array, ProtocolVersion version) {
        super(startposition, array, HandshakeMessageType.CERTIFICATE, version);
    }

    @Override
    protected void parseHandshakeMessageContent(CertificateMessage msg) {
        parseCertificatesLength(msg);
        parseX509CertificateBytes(msg);
        if(getVersion() == ProtocolVersion.TLS13) {
            if (hasExtensionLengthField(msg)) {
                parseExtensionLength(msg);
                if (hasExtensions(msg)) {
                    parseExtensionBytes(msg);
                }
            }
        }
    }

    @Override
    protected CertificateMessage createHandshakeMessage() {
        return new CertificateMessage();
    }

    /**
     * Reads the next bytes as the CertificateLength and writes them in the
     * message
     *
     * @param msg
     *            Message to write in
     */
    private void parseCertificatesLength(CertificateMessage msg) {
        msg.setCertificatesLength(parseIntField(HandshakeByteLength.CERTIFICATES_LENGTH));
        LOGGER.debug("CertificateLength: " + msg.getCertificatesLength().getValue());
    }

    /**
     * Reads the next bytes as the X509CertificateBytes and writes them in the
     * message
     *
     * @param msg
     *            Message to write in
     */
    private void parseX509CertificateBytes(CertificateMessage msg) {
        msg.setX509CertificateBytes(parseByteArrayField(msg.getCertificatesLength().getValue()));
        LOGGER.debug("X509CertificateBytes: "
                + ArrayConverter.bytesToHexString(msg.getX509CertificateBytes().getValue()));
    }

}
