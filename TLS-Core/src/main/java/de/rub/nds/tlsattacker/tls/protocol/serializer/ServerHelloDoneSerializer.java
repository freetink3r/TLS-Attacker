/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.tls.protocol.serializer;

import de.rub.nds.tlsattacker.tls.protocol.message.ServerHelloDoneMessage;
import de.rub.nds.tlsattacker.tls.protocol.parser.*;

/**
 *
 * @author Robert Merget - robert.merget@rub.de
 */
public class ServerHelloDoneSerializer extends HandshakeMessageSerializer<ServerHelloDoneMessage> {

    private final ServerHelloDoneMessage message;

    public ServerHelloDoneSerializer(ServerHelloDoneMessage message) {
        super(message);
        this.message = message;
    }

    @Override
    public byte[] serializeHandshakeMessageContent() {
        return getAlreadySerialized();
    }

}
