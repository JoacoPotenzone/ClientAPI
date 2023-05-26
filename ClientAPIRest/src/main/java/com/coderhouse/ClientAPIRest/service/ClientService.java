package com.coderhouse.ClientAPIRest.service;

import com.coderhouse.ClientAPIRest.model.Client;
import com.coderhouse.ClientAPIRest.model.ClientDTO;
import com.coderhouse.ClientAPIRest.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public Client crearCliente(Client cliente) {
        return clientRepository.save(cliente);
    }


    public ClientDTO getClient(int id) throws Exception {
        Optional<Client> cliente = clientRepository.findById((long) id);
        if (cliente.isEmpty()) {
            return null;
        } else {
            Client client = cliente.get();

            LocalDate cumpleaños = client.getFechaNacimiento();
            int age = calcularEdad(cumpleaños);


            ClientDTO clientDTO = new ClientDTO(client.getNombre(), client.getApellido(), age);
            return clientDTO;
        }
    }
    public static int calcularEdad (LocalDate cumpleaños) {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(cumpleaños,fechaActual);
        return periodo.getYears();
    }

}
