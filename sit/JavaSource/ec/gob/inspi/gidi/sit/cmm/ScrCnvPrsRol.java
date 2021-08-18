package ec.gob.inspi.gidi.sit.cmm;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ec.gob.inspi.gidi.sit.ent.ScrTblPrsRol;

@FacesConverter("scrCnvPrsRol")
// @FacesConverter(forClass = ScrTblPrsRol.class)
public class ScrCnvPrsRol implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (ScrTblPrsRol) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		if (value instanceof ScrTblPrsRol) {
			ScrTblPrsRol entity = (ScrTblPrsRol) value;
			if (entity != null && entity instanceof ScrTblPrsRol && entity.getIPrsRolId() != null) {
				uiComponent.getAttributes().put(entity.getIPrsRolId().toString(), entity);
				return entity.getIPrsRolId().toString();
			}
		}
		return "";
	}
}
