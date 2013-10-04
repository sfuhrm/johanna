/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.oneandone.idev.johanna.protocol.impl;

import java.util.logging.Logger;
import org.oneandone.idev.johanna.protocol.Request;
import org.oneandone.idev.johanna.protocol.Response;
import org.oneandone.idev.johanna.store.Session;
import org.oneandone.idev.johanna.store.SessionStore;

/**
 *
 * @author kiesel
 */
public class VarDeleteRequest extends SessionKeyBasedRequest {
    private static final Logger LOG = Logger.getLogger(VarDeleteRequest.class.getName());

    public VarDeleteRequest(String command) {
        super(command);
    }

    @Override
    public Response processSessionKey(SessionStore store, Session s, String name) {
        boolean removeValue = s.removeValue(name);
        if (!removeValue) return Response.NOKEY;
        return Response.OK;
    }
}