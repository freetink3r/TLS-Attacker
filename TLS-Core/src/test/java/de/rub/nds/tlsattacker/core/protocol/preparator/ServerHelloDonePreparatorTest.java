/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2017 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.core.protocol.preparator;

import de.rub.nds.tlsattacker.core.protocol.preparator.ServerHelloDonePreparator;
import de.rub.nds.tlsattacker.core.constants.CipherSuite;
import de.rub.nds.tlsattacker.core.constants.CompressionMethod;
import de.rub.nds.tlsattacker.core.constants.ProtocolVersion;
import de.rub.nds.tlsattacker.core.protocol.message.ServerHelloDoneMessage;
import de.rub.nds.tlsattacker.core.workflow.TlsContext;
import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Merget - robert.merget@rub.de
 */
public class ServerHelloDonePreparatorTest {

    private TlsContext context;
    private ServerHelloDoneMessage message;
    private ServerHelloDonePreparator preparator;

    public ServerHelloDonePreparatorTest() {
    }

    @Before
    public void setUp() {
        this.context = new TlsContext();
        this.message = new ServerHelloDoneMessage();
        this.preparator = new ServerHelloDonePreparator(context, message);
    }

    /**
     * Test of prepareHandshakeMessageContents method, of class
     * ServerHelloDonePreparator.
     */
    @Test
    public void testPrepare() {

        // just check that prepare does not throw an exception
    }

}