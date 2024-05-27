package models.repositories;

import com.google.gson.Gson;
import models.entities.ClienteEntity;
import models.entities.EnderecoAPI;
import models.entities.EnderecoEntity;
import models.entities.LocacaoEntity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class EnderecoRepository {
    private DAO<EnderecoEntity> dao;

    public EnderecoRepository() {
        dao = new DAO<>(EnderecoEntity.class);
    }

    public EnderecoAPI findEndereco(String cep) {
        if (cep.length()!= 8) {
            return null;
        }
        try {
            URL url = new URL("https://viacep.com.br/ws/" + cep + "/json");
            HttpURLConnection conect = (HttpURLConnection) url.openConnection();
            conect.setRequestMethod("GET");
            BufferedReader data = new BufferedReader(new InputStreamReader(conect.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = data.readLine())!= null) {
                response.append(inputLine);
            }
            data.close();
            Gson gson = new Gson();
            return gson.fromJson(response.toString(), EnderecoAPI.class);
        } catch (Exception e) {
            System.out.println("Algum erro aconteceu ao consultar CEP verifique se o cep foi inserido corretamente!");
            e.printStackTrace();
        }
        return null;
    }

    public Long create(Object object) {
        EnderecoEntity endereco = (EnderecoEntity) object;
        dao.openConnection().insert(endereco).closeConnection();
        Long enderecoId = endereco.getId();

        if(enderecoId != null){
            System.out.println("Cliente criado com sucesso!");
            return enderecoId;
        }
        return null;
    }

    public Object update(Object object) {
        EnderecoEntity endereco = (EnderecoEntity) object;
        dao.openConnection().update(endereco);
        dao.closeConnection();
        return null;
    }
}
