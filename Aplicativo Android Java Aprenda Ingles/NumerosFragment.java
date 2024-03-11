public class NumerosFragment extends Fragment implements View.OnClickListener {

    private ImageButton buttonUm, buttonDois, buttonTres,
            buttonQuatro, buttonCinco, buttonSeis;
    private MediaPlayer mediaPlayer;

    public NumerosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        // Inicialização dos botões
        buttonUm = view.findViewById(R.id.buttonUm);
        buttonDois = view.findViewById(R.id.buttonDois);
        buttonTres = view.findViewById(R.id.buttonTres);
        buttonQuatro = view.findViewById(R.id.buttonQuatro);
        buttonCinco = view.findViewById(R.id.buttonCinco);
        buttonSeis = view.findViewById(R.id.buttonSeis);

        // Configuração dos listeners de clique
        buttonUm.setOnClickListener(this);
        buttonDois.setOnClickListener(this);
        buttonTres.setOnClickListener(this);
        buttonQuatro.setOnClickListener(this);
        buttonCinco.setOnClickListener(this);
        buttonSeis.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }

        switch (view.getId()) {
            case R.id.buttonUm:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one);
                break;
            case R.id.buttonDois:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two);
                break;
            case R.id.buttonTres:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three);
                break;
            case R.id.buttonQuatro:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four);
                break;
            case R.id.buttonCinco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five);
                break;
            case R.id.buttonSeis:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six);
                break;
        }

        tocarSom();
    }

    public void tocarSom() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(mp -> mediaPlayer.release());
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}