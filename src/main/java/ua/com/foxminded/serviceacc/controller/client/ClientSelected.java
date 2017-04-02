package ua.com.foxminded.serviceacc.controller.client;

import javax.inject.Inject;
import javax.inject.Named;

import ua.com.foxminded.serviceacc.model.domain.ClientView;
import ua.com.foxminded.serviceacc.service.ClientServices;

@Named
public class ClientSelected {

	@Inject
	private ClientServices clientServices;

	@Inject
	private ClientController clientController;

	@Inject
	private ClientUpdate clientUpdate;

	private ClientView selectedClient;

	private boolean isShowSelectedClientForm;

	public void hide() {
		clientUpdate.hide();
		setIsShowSelectedClientForm(false);
	}

	public void show() {
		clientUpdate.hide();
		setIsShowSelectedClientForm(true);
	}

	public void selectedFormOnOk() {
		hide();
	}

	public void selectedFormOnDelete() {
		clientServices.delete(selectedClient);
		clientController.allClientsUpdate();
		hide();
	}

	public void selectedFormOnUpdate() {
		hide();
		clientController.blockTable();
		clientUpdate.init(selectedClient);
		clientUpdate.show();
		clientController.allClientsUpdate();
	}

	public void selectedFormOnUpdateComplete() {
		clientController.unBlockTable();
		clientController.allClientsUpdate();
		clientUpdate.hide();
		selectedClient = null;

	}

	public ClientServices getClientServices() {
		return clientServices;
	}

	public void setClientServices(ClientServices clientServices) {
		this.clientServices = clientServices;
	}

	public ClientController getClients() {
		return clientController;
	}

	public void setClients(ClientController clientController) {
		this.clientController = clientController;
	}

	public boolean getIsShowSelectedClientForm() {
		return isShowSelectedClientForm;
	}

	public void setIsShowSelectedClientForm(boolean isShowSelectedClientForm) {
		this.isShowSelectedClientForm = isShowSelectedClientForm;
	}

	public ClientView getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(ClientView selectedClient) {
		this.selectedClient = selectedClient;
	}

	public ClientUpdate getClientUpdate() {
		return clientUpdate;
	}

	public void setClientUpdate(ClientUpdate clientUpdate) {
		this.clientUpdate = clientUpdate;
	}

}
