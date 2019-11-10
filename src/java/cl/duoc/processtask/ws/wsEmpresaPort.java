/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.duoc.processtask.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * REST Web Service
 *
 * @author jorge
 */
@Path("wsempresaport")
public class wsEmpresaPort {
    private cl.duoc.processtask.ws_client1.WsEmpresa port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of wsEmpresaPort
     */
    public wsEmpresaPort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method actualizarEmpresa
     * @param idEmpresa resource URI parameter
     * @param rut resource URI parameter
     * @param direccion resource URI parameter
     * @param nombreEmpresa resource URI parameter
     * @param contacto resource URI parameter
     * @param correo resource URI parameter
     * @param vigente resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<cl.duoc.processtask.ws_client1.ActualizarEmpresaResponse>
     */
    @GET
    @Produces("application/xml")
    @Consumes("text/plain")
    @Path("actualizarempresa/")
    public JAXBElement<cl.duoc.processtask.ws_client1.ActualizarEmpresaResponse> getActualizarEmpresa(@QueryParam("idEmpresa")
            @DefaultValue("0") long idEmpresa, @QueryParam("rut") String rut, @QueryParam("direccion") String direccion, @QueryParam("nombreEmpresa") String nombreEmpresa, @QueryParam("contacto") String contacto, @QueryParam("correo") String correo, @QueryParam("vigente")
            @DefaultValue("0") short vigente) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.util.List<cl.duoc.processtask.ws_client1.Empresa> result = port.actualizarEmpresa(idEmpresa, rut, direccion, nombreEmpresa, contacto, correo, vigente);

                class ActualizarEmpresaResponse_1 extends cl.duoc.processtask.ws_client1.ActualizarEmpresaResponse {

                    ActualizarEmpresaResponse_1(java.util.List<cl.duoc.processtask.ws_client1.Empresa> _return) {
                        this._return = _return;
                    }
                }
                cl.duoc.processtask.ws_client1.ActualizarEmpresaResponse response = new ActualizarEmpresaResponse_1(result);
                return new cl.duoc.processtask.ws_client1.ObjectFactory().createActualizarEmpresaResponse(response);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method registrarEmpresa
     * @param rut resource URI parameter
     * @param direccion resource URI parameter
     * @param nombreEmpresa resource URI parameter
     * @param contacto resource URI parameter
     * @param correo resource URI parameter
     * @param vigente resource URI parameter
     * @return an instance of java.lang.String
     */
    @POST
    @Produces("text/plain")
    @Consumes("application/xml")
    @Path("registrarempresa/")
    public String postRegistrarEmpresa(String rut, String direccion, String nombreEmpresa, String contacto, String correo, JAXBElement<Short> vigente) {
        try {
            // Call Web Service Operation
            if (port != null) {
                boolean result = port.registrarEmpresa(rut, direccion, nombreEmpresa, contacto, correo, vigente.getValue());
                return new java.lang.Boolean(result).toString();
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method listarEmpresaById
     * @param idEmpresa resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<cl.duoc.processtask.ws_client1.ListarEmpresaByIdResponse>
     */
    @GET
    @Produces("application/xml")
    @Consumes("text/plain")
    @Path("listarempresabyid/")
    public JAXBElement<cl.duoc.processtask.ws_client1.ListarEmpresaByIdResponse> getListarEmpresaById(@QueryParam("idEmpresa")
            @DefaultValue("0") long idEmpresa) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.util.List<cl.duoc.processtask.ws_client1.Empresa> result = port.listarEmpresaById(idEmpresa);

                class ListarEmpresaByIdResponse_1 extends cl.duoc.processtask.ws_client1.ListarEmpresaByIdResponse {

                    ListarEmpresaByIdResponse_1(java.util.List<cl.duoc.processtask.ws_client1.Empresa> _return) {
                        this._return = _return;
                    }
                }
                cl.duoc.processtask.ws_client1.ListarEmpresaByIdResponse response = new ListarEmpresaByIdResponse_1(result);
                return new cl.duoc.processtask.ws_client1.ObjectFactory().createListarEmpresaByIdResponse(response);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method listarAllEmpresa
     * @return an instance of javax.xml.bind.JAXBElement<cl.duoc.processtask.ws_client1.ListarAllEmpresaResponse>
     */
    @GET
    @Produces("application/xml")
    @Consumes("text/plain")
    @Path("listarallempresa/")
    public JAXBElement<cl.duoc.processtask.ws_client1.ListarAllEmpresaResponse> getListarAllEmpresa() {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.util.List<cl.duoc.processtask.ws_client1.Empresa> result = port.listarAllEmpresa();

                class ListarAllEmpresaResponse_1 extends cl.duoc.processtask.ws_client1.ListarAllEmpresaResponse {

                    ListarAllEmpresaResponse_1(java.util.List<cl.duoc.processtask.ws_client1.Empresa> _return) {
                        this._return = _return;
                    }
                }
                cl.duoc.processtask.ws_client1.ListarAllEmpresaResponse response = new ListarAllEmpresaResponse_1(result);
                return new cl.duoc.processtask.ws_client1.ObjectFactory().createListarAllEmpresaResponse(response);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method eliminarEmpresaById
     * @param idEmpresa resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<cl.duoc.processtask.ws_client1.EliminarEmpresaByIdResponse>
     */
    @GET
    @Produces("application/xml")
    @Consumes("text/plain")
    @Path("eliminarempresabyid/")
    public JAXBElement<cl.duoc.processtask.ws_client1.EliminarEmpresaByIdResponse> getEliminarEmpresaById(@QueryParam("idEmpresa")
            @DefaultValue("0") long idEmpresa) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.util.List<cl.duoc.processtask.ws_client1.Empresa> result = port.eliminarEmpresaById(idEmpresa);

                class EliminarEmpresaByIdResponse_1 extends cl.duoc.processtask.ws_client1.EliminarEmpresaByIdResponse {

                    EliminarEmpresaByIdResponse_1(java.util.List<cl.duoc.processtask.ws_client1.Empresa> _return) {
                        this._return = _return;
                    }
                }
                cl.duoc.processtask.ws_client1.EliminarEmpresaByIdResponse response = new EliminarEmpresaByIdResponse_1(result);
                return new cl.duoc.processtask.ws_client1.ObjectFactory().createEliminarEmpresaByIdResponse(response);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private cl.duoc.processtask.ws_client1.WsEmpresa getPort() {
        try {
            // Call Web Service Operation
            cl.duoc.processtask.ws_client1.WsEmpresa_Service service = new cl.duoc.processtask.ws_client1.WsEmpresa_Service();
            cl.duoc.processtask.ws_client1.WsEmpresa p = service.getWsEmpresaPort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}
