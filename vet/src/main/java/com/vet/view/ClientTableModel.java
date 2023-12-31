package view;

import java.util.List;
import model.Client;
import model.ClientDAO;

public class ClientTableModel extends GenericTableModel {

    public ClientTableModel(List vDados){
        super(vDados, new String[]{"Nome","Endereço", "CEP", "email", "Celular"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Client client = (Client) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return client.getName();
            case 1:
                return client.getAddress();
            case 2:
                return client.getZip();
            case 3:
                return client.getEmail();
            case 4:
                return client.getPhone();                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }    
    
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Client client = (Client) vDados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                client.setName((String)aValue);
                break;
            case 1:
                client.setAddress((String)aValue);
                break;
            case 2:
                client.setZip((String)aValue);    
                break;
            case 3:
                client.setEmail((String)aValue);
                break;
            case 4:
                client.setPhone((String)aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
        ClientDAO.getInstance().update(client);
    }    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //if (columnIndex == 0) return false;
        return true;
    }      
    
}
