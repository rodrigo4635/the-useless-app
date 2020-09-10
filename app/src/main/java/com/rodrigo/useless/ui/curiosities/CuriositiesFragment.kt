package com.rodrigo.useless.ui.curiosities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.rodrigo.useless.R
import kotlin.random.Random

class CuriositiesFragment : Fragment() {
    private val quotes = arrayOf(
        "Ratos não vomitam",
        "Os russos atendem ao telefone dizendo 'Estou ouvindo'",
        "O elefante é o único animal com quatro joelhos",
        "A cada ano, 98% dos átomos do seu corpo são substituídos",
        "Se você gritar por 8 anos, 7 meses e 6 dias, produzirá energia o suficiente para esquentar uma xícara de café",
        "A NASA foi obrigada a renomear os tamanhos do aparato utilizado pelos astronautas para fazer xixi. Em vez de pequeno, médio e grande, eles foram chamados de grande, gigante e enorme porque os astronautas se recusavam a escolher o tamanho mais adequado;",
        "É possível estimar a temperatura (em Fahrenheit) contando o número de vezes que um grilo estrila em 15 segundos e adicionar o número 37",
        "A altura ideal para derrubar uma torrada com manteiga e fazer com que ela caia com a manteiga para cima é 2,43 metros",
        "Cleópatra viveu mais próximo à invenção do iPhone do que à construção da Grande Pirâmide de Gizé",
        "A Universidade de Oxford é mais antiga do que o Império Asteca",
        "Um bilhão é muita coisa! Um bilhão de segundos, por exemplo, equivale a aproximadamente 32 anos",
        "Você não consegue zumbir se tampar o nariz",
        "Você tem 10 vezes mais bactérias do que células no seu corpo",
        "Se você cavasse um túnel através da Terra e pulasse dentro, você demoraria 42 minutos e 12 segundos para chegar do outro lado",
        "Os polvos têm três corações e as fêmeas de cangurus têm dois úteros e três vaginas",
        "A Terra fica 100 kg mais pesada todo dia devido a queda de pó espacial",
        "Um raio contêm energia para torrar 160 mil fatias de pão",
        "A água viva Turritopsis é biologicamente imortal",
        "Os babuínos já foram treinados pelos egípcios para servirem a mesa e esperar de pé até terminar a refeição",
        "As impressões do cachorro fica no seu nariz, assim como a impressão humana fica no polegar",
        "O título mais longo de um livro é de 670 palavras",
        "Sapos não gostam de bebida alcoólica",
        "A mentira mais contada é 'Estou Bem'",
        "A Anatidaefobia é o medo que um pato esteja observando você",
        "Vacas conseguem subir escadas, mas não conseguem descer",
        "Se os tubarões ficarem de cabeça para baixo, eles entram em coma",
        "Caracóis podem dormir por 3 anos",
        "É impossivel criar uma pasta com o nome 'con' se você tiver Windows",
        "A luta mais longa de boxe durou 110 rounds",
        "Alexander Graham Bell, o inventor do telefone, não podia ligar para sua mulher, ela era surda",
        "Você enxerga melhor quando está assustado",
        "Os dias 3,4,5,6,7,8,9,10,11,12 e 13 não existiram em 1752",
        "O piloto da Nascar Tim Flock é o único piloto da história a fazer um pit stop para retirar um macaco do carro",
        "Se você comer muita cenoura é possível que sua pele fique laranja",
        "O pássaro Lira pode imitar qualquer som que ele escuta",
        "Os homens que partem o cabelo para a direita geralmente vivem mais dos que partem para a esquerda",
        "As pessoas são mais altas de manhã do que de noite",
        "O recorde de vôo de uma galinha é de 13 segundos",
        "É proibido entrar no México com mais de 2 CD’S",
        "A maior altura que um ovo já caiu sem quebrar foi de 213, 36 metros de altura",
        "Se você colocar uma abelha no freezer ela vai dormir",
        "Uma mosca reage a algo em 30 milésimos de segundos"
        )
    private val usedIndexes = mutableListOf<Int>()
    private lateinit var curiositiesViewModel: CuriositiesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        curiositiesViewModel =
            ViewModelProviders.of(this).get(CuriositiesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_curiosities, container, false)
        val btn: Button = root.findViewById(R.id.button_generate_curiosity)
        val textView: TextView = root.findViewById(R.id.curiosities_text_view)
        btn.setOnClickListener {
            textView.text = getRandomQuote()
        }
        return root
    }
    private fun getRandomQuote(): String {
        if (usedIndexes.size == quotes.size) {
            return "Todas as curiosidades já foram lidas. Parabéns, você acabou de gastar 7 minutos lendo mais de 600 palavras (Se é que você leu né)"
        }
        var randomIndex = Random.nextInt(quotes.size)
        while (usedIndexes.contains(randomIndex)) {
            randomIndex = Random.nextInt(quotes.size)
        }
        usedIndexes.add(randomIndex)
        return quotes[randomIndex]
    }
}