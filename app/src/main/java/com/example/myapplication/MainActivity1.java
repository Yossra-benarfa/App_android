package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
public class MainActivity1 extends AppCompatActivity {

    RecyclerView myrecyclerView;
    RecyclerViewAdapter myAdapter;

    List<Recipes> recipes1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        recipes1 = new ArrayList<>();

        recipes1.add(new Recipes(
                "Petit Déjeuner","Corps Normale: \n" +
                "* Un petit-déjeuner  se compose d'un produit à base de céréales tel que pain ou \n" +
                "* Biscotte avec un peu de beurre \n"+"* de confiture ou de miel selon les goûts d'un produit laitier \n" +
                "* Lait, yaourt, fromage blanc demi-écrémé \n"+
                "* Fruit ou d'un jus de fruits frais ou sans sucre ajouté \n ",
                "Famine",
                "* Boisson pour réhydrater le corps comme du café \n " +
                        "* Thé ou du jus de fruit.\n" +
                        "* Fruits pour les vitamines. \n" +
                        "* Produit laitier pour le calcium \n" +
                        "* Les protéines avec un verre de lait \n" +
                        "* Yaourt ou pourquoi pas du fromage si le cœur vous en dit.\n" +
                        "* Du pain complet.\n",
                "Surpoid",
                "*2 tranches de pain (complet ou aux céréales, environ 50 grammes) \n " +
                        "* 1 portion de protéines (30 à 40 grammes soit 1 œuf ou 1 morceau de fromage ou 1 tranche de jambon)\n" +
                        "* + 1 portion de fruits (150 grammes) + 1 boisson chaude sans sucre\n"
                ,R.drawable.petitdej));

        recipes1.add(new Recipes(
                "Déjeuner Midi", "Corps Normale: \n" +
                "* Salade de riz brun \n"+ "* poulet et légumes\n" +
                "* Yogourt \n"+ "* jus de légumes.\n"+
                "* Pain tortillas au blé entier avec garniture au thon \n " +
                "* Crudités \n"+"* verre de lait\n"+
                "* Couscous aux pois chiches avec légumes\n" +
                "* morceaux de fromage \n " +
                "* Eau \n" +"* salade de fruits","Surpoids","\n" +
                "* Rouleaux de printemps crevettes \n"+"* pomme verte \n" +
                "* Salade de pousses de soja \n" +
                "* Pâtes complètes au pesto d'épinards \n"+"* brocoli et féta Salade de fruits \n"+
                "* Salade de carottes \n" +
                "* Poulet aux olives et citron confit \n" + "* Semoule \n" +
                "* Wrap au saumon \n"+"* citron et concombre \n" +
                "* Salade de pousses d'épinard \n" +
                "* Compote de fruit \n"+
                "* Salade complète de quinoa \n"+"* poivrons et pois chiches \n" +
                "* Fruit de saison",
                "Famine",
                "* Soupe de palourdes \n" +
                        "* poisson à l'orange \n" +
                        "* Salade de tomates \n" +
                        "* fromage fêta \n" +
                        "* Deux tranches de pain (blé entier)",
                R.drawable.dejeuner));
        recipes1.add(new Recipes(
                "Dessert ","Corps Normale: \n" +
                "* Un bol en noix de coco. \n"+ "* yaourt (végétal).\n" +
                "* Du granola bio et des fruits frais\n","Surpoids",
                "* Verrine de kiwis au fromage blanc 0% \n" +
                        "* Gâteau au yaourt diététique au son d'avoine.\n" +
                        "* Muffins au chocolat et courgette pour brûler les graisses.\n" +
                        "* Panna cotta au thé vert et menthe.\n" +
                        "* Crumble pommes-poire au son d'avoine spécial brûle graisse.\n" +
                        "* Fromage blanc 0% au coulis de mangue",
                "Famine",
                "* Frozen yogurt\n\n" +
                        "* Brochettes de fruits \n" +
                        "* Tiramisu allégé \n" +
                        "* Sorbets aux fruits \n" +
                        "* Panna cotta light",

                R.drawable.dessert));
        recipes1.add(new Recipes(
                "Dîner","Corps Normale: \n" +
                "* Omelette au formage\n"+
                "* Salade de pâtes au thon\n " +
                "* tomate et mâis\n"+
                "* Pomme de terre farcie aux lardons et brocoli\n "
                +"*Pizza au poulet\n "+
                "* clafoutis au jambon\n"+
                "* Oeuf cocotte à la créme\n"+"* tartare de saumon\n"
                ,"Surpoids",
                "* Pizza light aux légumes, sans pâte\n" +
                        "* Salade verte\n" +
                      "* Hachis parmentier à la courge et au poulet\n" +
                        "Salade d'endives\n" +
                       "* Coleslaw au yaourt\n" +
                        "* Tarte fine au thon et à la tomate\n" +
                        "* Ananas rôti au four\n"+
                        "* Fromage blanc\n"+
                        "* Sauté de tofu aux noix de cajou et haricots plats\n" +
                        "* Riz brun\n" + "* Fromage frais\n" + "* Fruit frais\n"+
                        "* Taboulé frais à la menthe et aux fèves\n" +
                        "* Boulettes de boeuf maigre, sauce au yaourt\n" +
                        "* Compote maison\n"+
                        "* Yaourt aux fruits rouges\n",
                "Famine",
                "* Mettez des aliments riches en tryptophane \n" +
                        "*  Un acide aminé essentiel qu'on retrouve dans les œufs \n" +
                        "* La volaille, \n " +
                        "* Le poisson, \n" +
                        "* Les légumineuses \n" +
                        "* Le riz complet \n",
                R.drawable.diner));

        recipes1.add(new Recipes(" Boissons","Corps Normale: \n" +
                "* Eau.\n" +
                "* Lait.\n" +
                "* Jus et boissons à base de jus.\n" +
                "* Boissons de sommeil.\n" +
                "* Sodas.\n" +
                "* Autres boissons sans alcool.\n" +
                "* Bière.\n" +
                "* Cidre.","Surpoids",
                "* Le jus de citron.\n"+"* un véritable allié minceur.\n" +
                        "* L'infusion ventre plat : cannelle, gingembre et citron.\n" +
                        "* Le thé vert\n"+ "* un brûle-graisse naturel.\n"+
                        "* Les jus de légumes verts pour favoriser la satiété et le transit.",
                "Famine",
                "* L'eau \n" +
                        "* Les jus de légumes \n"+
                "* Jus de fruits (ananas, tomates, citrons, litchis, oranges, coco, etc),",
                R.drawable.boisson));



        myrecyclerView = (RecyclerView)findViewById(R.id.recyclerView_id);

        myAdapter = new RecyclerViewAdapter(this,recipes1);

        myrecyclerView.setLayoutManager(new GridLayoutManager(this,1));

        myrecyclerView.setAdapter(myAdapter);



    }


}
