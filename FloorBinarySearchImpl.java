package problems;

import java.util.ArrayList;
import java.util.List;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		int indexInicio = 0;
		int indexFim = array.length - 1;
		int candidato = (indexFim + indexInicio)/2;
		List<Integer> candidatos = new ArrayList<>();

		//VALIDANDO SE EXISTE FLOOR

		int menorValor = array[0];

		if(x < menorValor){
			return null;
		}

		//ADICIONANDO CANDIDATOS NUMA LISTA

		while(array[candidato] != x && (indexFim - indexInicio) >= 2){
			if(array[candidato] < x){
				candidatos.add(array[candidato] - x);
				indexInicio = candidato + 1;
				candidato = (indexInicio + indexFim)/2;
				if (indexFim - indexInicio == 0){
					candidatos.add(array[indexFim] - x);
				}
			} else {
				candidatos.add(array[candidato] - x);
				indexFim = candidato - 1;
				candidato = (indexInicio + indexFim) / 2;
				if(indexFim - indexInicio == 0){
					candidatos.add(array[indexInicio] - x);
				}
			}
		}

		if(array[candidato] == x){
			return candidato;
		}

		//ESCOLHENDO CANDIDATO

		int candidatoEscolhido = candidatos.get(0);

		for(int i = 0; i < candidatos.size(); i++){

			if(candidatos.get(i) < candidatoEscolhido){
				candidatoEscolhido = candidatos.get(i);
			}

		}
		return candidatoEscolhido + x;

	}

}
