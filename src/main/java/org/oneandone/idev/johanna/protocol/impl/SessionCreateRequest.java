/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.oneandone.idev.johanna.protocol.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.oneandone.idev.johanna.protocol.Request;
import org.oneandone.idev.johanna.protocol.Response;
import org.oneandone.idev.johanna.store.Identifier;
import org.oneandone.idev.johanna.store.MD5Identifier;
import org.oneandone.idev.johanna.store.Session;
import org.oneandone.idev.johanna.store.SessionStore;

/**
 *
 * @author kiesel
 */
public class SessionCreateRequest extends Request {
    private static final Logger LOG = Logger.getLogger(SessionCreateRequest.class.getName());

    public SessionCreateRequest(String command) {
        super(command);
    }

    @Override
    public Response process(SessionStore store) {
        Identifier id= new MD5Identifier(this.prefix);
        
        Session s= store.createSession(id, Integer.parseInt(this.paramAt(1)));
        LOG.log(Level.INFO, "Created session {0} w/ TTL {1}", new Object[]{s.getId(), s.getTTL()});
        
        return new Response(true, s.getId());
    }
}
