/*
 * Copyright (C) 2012 Controlled Capture Systems, LLC
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.androidaq;
 
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
 








import com.androidaq.AndroiDAQTCPMain;

import java.util.ArrayList;
import java.util.Arrays;
 
//public class AndroiDAQTCPAdapter extends PagerAdapter implements ScrollViewListener { 
	public class AndroiDAQTCPAdapter extends PagerAdapter { 
	
	View v;
	
	private CheckBox p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15;
	
	private TableRow inputsRow0, inputsRow1, inputsRow2, inputsRow3, inputsRow4, inputsRow5, inputsRow6, inputsRow7;
	private TableRow inputsRow8, inputsRow9, inputsRow10, inputsRow11, inputsRow12, inputsRow13, inputsRow14, inputsRow15;
	private TableRow outputsRow0, outputsRow1, outputsRow2, outputsRow3, outputsRow4, outputsRow5, outputsRow6, outputsRow7;
	private TableRow outputsRow8, outputsRow9, outputsRow10, outputsRow11, outputsRow12, outputsRow13, outputsRow14, outputsRow15;
	private TableRow voltagesRow0, voltagesRow1, voltagesRow2, voltagesRow3, voltagesRow4, voltagesRow5, voltagesRow6, voltagesRow7 ;
	
	private RadioButton hiLow0, hiLow1, hiLow2, hiLow3, hiLow4, hiLow5, hiLow6, hiLow7;
	private RadioButton hiLow8, hiLow9, hiLow10, hiLow11, hiLow12, hiLow13, hiLow14, hiLow15;
	private RadioButton allDigIn0, allDigIn1, allDigIn2, allDigIn3, allDigIn4, allDigIn5, allDigIn6, allDigIn7;
	private RadioButton allDigIn8, allDigIn9, allDigIn10, allDigIn11, allDigIn12, allDigIn13, allDigIn14, allDigIn15;
	
	private CheckBox out_hiLow0, out_hiLow1, out_hiLow2, out_hiLow3, out_hiLow4, out_hiLow5, out_hiLow6, out_hiLow7, out_hiLow8;
	private CheckBox out_hiLow9, out_hiLow10, out_hiLow11, out_hiLow12, out_hiLow13, out_hiLow14, out_hiLow15;
	private CheckBox allDigOut0, allDigOut1, allDigOut2, allDigOut3, allDigOut4, allDigOut5, allDigOut6, allDigOut7;
	private CheckBox allDigOut8, allDigOut9, allDigOut10, allDigOut11, allDigOut12, allDigOut13, allDigOut14, allDigOut15;

	private TextView freq0, freq1, freq2, freq3, freq4, freq5, freq6, freq7, freq8, freq9, freq10, freq11, freq12, freq13, freq14, freq15;
	private TextView allFreqIn0, allFreqIn1, allFreqIn2, allFreqIn3, allFreqIn4, allFreqIn5, allFreqIn6, allFreqIn7;
	private TextView allFreqIn8, allFreqIn9, allFreqIn10,allFreqIn11, allFreqIn12, allFreqIn13, allFreqIn14, allFreqIn15;
	
	private EditText out_freq0, out_freq1, out_freq2, out_freq3, out_freq4, out_freq5, out_freq6, out_freq7, out_freq8;
	private EditText out_freq9, out_freq10, out_freq11, out_freq12, out_freq13, out_freq14, out_freq15;
	private EditText duty_freq0, duty_freq1, duty_freq2, duty_freq3, duty_freq4, duty_freq5, duty_freq6, duty_freq7, duty_freq8;
	private EditText duty_freq9, duty_freq10, duty_freq11, duty_freq12, duty_freq13, duty_freq14, duty_freq15;
	private EditText allFreqOut0, allFreqOut1, allFreqOut2, allFreqOut3, allFreqOut4, allFreqOut5, allFreqOut6, allFreqOut7, allFreqOut8;
	private EditText allFreqOut9, allFreqOut10, allFreqOut11, allFreqOut12, allFreqOut13, allFreqOut14, allFreqOut15;
	private EditText allDutyOut0, allDutyOut1, allDutyOut2, allDutyOut3, allDutyOut4, allDutyOut5, allDutyOut6, allDutyOut7, allDutyOut8;
	private EditText allDutyOut9, allDutyOut10, allDutyOut11, allDutyOut12, allDutyOut13, allDutyOut14, allDutyOut15;
	private EditText samples;
	private Spinner ratesList;
	
	public WaveFormView mWaveform = null;
	int[] wfdata = new int[4096];
	private TextView waveRate;
	
	//private String desiredFreq0, desiredFreq1, desiredFreq2, desiredFreq3, desiredFreq4, desiredFreq5, desiredFreq6, desiredFreq7;
	//private String desiredFreq8, desiredFreq9, desiredFreq10, desiredFreq11, desiredFreq12, desiredFreq13, desiredFreq14, desiredFreq15;
	
	@SuppressWarnings("unused")
	private TextView allVoltCh0, allVoltCh1, allVoltCh2, allVoltCh3, allVoltCh4, allVoltCh5, allVoltCh6, allVoltCh7;
	private TextView allVoltReading0, allVoltReading1, allVoltReading2, allVoltReading3, allVoltReading4, allVoltReading5, allVoltReading6, allVoltReading7;
	@SuppressWarnings("unused")
	private TextView allVoltLabel0, allVoltLabel1, allVoltLabel2, allVoltLabel3, allVoltLabel4, allVoltLabel5, allVoltLabel6, allVoltLabel7;
	private TextView allFreqLabel0, allFreqLabel1, allFreqLabel2, allFreqLabel3, allFreqLabel4, allFreqLabel5, allFreqLabel6, allFreqLabel7;
	private TextView allFreqLabel8, allFreqLabel9, allFreqLabel10, allFreqLabel11, allFreqLabel12, allFreqLabel13, allFreqLabel14, allFreqLabel15;
	private TextView allDutyLabel0, allDutyLabel1, allDutyLabel2, allDutyLabel3, allDutyLabel4, allDutyLabel5, allDutyLabel6, allDutyLabel7;
	private TextView allDutyLabel8, allDutyLabel9, allDutyLabel10, allDutyLabel11, allDutyLabel12, allDutyLabel13, allDutyLabel14, allDutyLabel15;
	private TextView inFreqLabel0, inFreqLabel1, inFreqLabel2, inFreqLabel3, inFreqLabel4, inFreqLabel5, inFreqLabel6, inFreqLabel7;
	private TextView inFreqLabel8, inFreqLabel9, inFreqLabel10, inFreqLabel11, inFreqLabel12, inFreqLabel13, inFreqLabel14, inFreqLabel15;
	private TextView outFreqLabel0, outFreqLabel1, outFreqLabel2, outFreqLabel3, outFreqLabel4, outFreqLabel5, outFreqLabel6, outFreqLabel7;
	private TextView outFreqLabel8, outFreqLabel9, outFreqLabel10, outFreqLabel11, outFreqLabel12, outFreqLabel13, outFreqLabel14, outFreqLabel15;
	private TextView outDutyLabel0, outDutyLabel1, outDutyLabel2, outDutyLabel3, outDutyLabel4, outDutyLabel5, outDutyLabel6, outDutyLabel7;
	private TextView outDutyLabel8, outDutyLabel9, outDutyLabel10, outDutyLabel11, outDutyLabel12, outDutyLabel13, outDutyLabel14, outDutyLabel15;
	private TextView logText;
	private TextView volts1, volts2, volts3, volts4, volts5, volts6, volts7, volts8;
	
	private RadioGroup rg0, rg1, rg2, rg3, rg4, rg5, rg6, rg7, rg8, rg9, rg10, rg11, rg12, rg13, rg14, rg15;
	private RadioGroup rg16, rg17, rg18, rg19, rg20, rg21, rg22, rg23, rg24, rg25, rg26, rg27, rg28, rg29, rg30, rg31;
	
	//private ObservableScrollView setupSV = null;
	private ScrollView setupSV;
	private ScrollView inputSV;
	private ScrollView outputSV;
	private ScrollView voltsSV;
	private ScrollView allSV;
	private ScrollView adcSV;
	private ScrollView logSV;
	
	private Button refreshLog;
	private Button setRun;
	private Button setupMenu;
	private Button openMenu;
	private Button inputSetRun;
	private Button inputContRun;
	private Button outputSend;
	private Button outputReset;
	private Button readVolts;
	private Button readContVolts;
	private Button resetValues;
	private Button readSamples;
	
	private Button forward;
	private Button reverse;
	private Button left;
	private Button right;
	private SeekBar speed;
	private int speedPercent;

	private boolean isOutputCh0 = false;
	private boolean isOutputCh1 = false;
	private boolean isOutputCh2 = false;
	private boolean isOutputCh3 = false;
	private boolean isOutputCh4 = false;
	private boolean isOutputCh5 = false;
	private boolean isOutputCh6 = false;
	private boolean isOutputCh7 = false;
	private boolean isOutputCh8 = false;
	private boolean isOutputCh9 = false;
	private boolean isOutputCh10 = false;
	private boolean isOutputCh11 = false;
	private boolean isOutputCh12 = false;
	private boolean isOutputCh13 = false;
	private boolean isOutputCh14 = false;
	private boolean isOutputCh15 = false;

	private boolean isDigCh0 = true;
	private boolean isDigCh1 = true;
	private boolean isDigCh2 = true;
	private boolean isDigCh3 = true;
	private boolean isDigCh4 = true;
	private boolean isDigCh5 = true;
	private boolean isDigCh6 = true;
	private boolean isDigCh7 = true;
	private boolean isDigCh8 = true;
	private boolean isDigCh9 = true;
	private boolean isDigCh10 = true;
	private boolean isDigCh11 = true;
	private boolean isDigCh12 = true;
	private boolean isDigCh13 = true;
	private boolean isDigCh14 = true;
	private boolean isDigCh15 = true;

	private boolean runInputs = false;
	private boolean runContInputs = false;
	private boolean sendOutputs = false;
	private boolean runVolts = false;
	private boolean runContVolts = false;
	private boolean runAll = false;
	private boolean buttonDown = false;
	
	boolean[] isOutputCh = new boolean[16];
	boolean[] isDigCh = new boolean[16];
	boolean[] readVoltage = new boolean[8];
	boolean[] outputState = new boolean[16];
	String[] desiredFreq = new String[16];
	String[] desiredDuty = new String[16];
	String itemText;
	
	private ArrayList<String> chsAreInputs;
	
	private InputMethodManager imm;
    private static String[] titles = new String[]
    {
    	"Setup I/O",
        "Input Settings",
        "Output Settings",
        "Volt Readings",
        "All Channels",
        "Log Screen",
        "ADC Sample",
        "ADC Waveform",
        "Remote"
    };
    public Context context;
 
    public AndroiDAQTCPAdapter(Context context)
    {
        this.context = context;
        this.imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        Arrays.fill(readVoltage, Boolean.TRUE);
        Arrays.fill(isDigCh, Boolean.TRUE);
        Arrays.fill(desiredFreq, "0");
        Arrays.fill(desiredDuty, "50");
    }
 
    //This is the title of the page that will apppear on the "tab"
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
 
    @Override
    public int getCount()
    {
        return titles.length;
    }
 
    @Override
    public Object instantiateItem(View collection, int position) {
    	//Log.e("Test", "instantiateItem");
    	v = new View(collection.getContext());
        LayoutInflater inflater = (LayoutInflater) collection.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        int resId = 0;
        switch (position) {
        case 0:
            resId = R.layout.setup;
            v = inflater.inflate(resId, null, false);  	
            //setupSV = (ObservableScrollView) v.findViewById(R.id.setupSV);
            setupSV = (ScrollView) v.findViewById(R.id.setupSV);
            //setupSV.setScrollViewListener(this);
            setupMenu = (Button)v.findViewById(R.id.setup_menu);
            setupMenu.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                	((AndroiDAQTCPMain)context).openMenu();
                }
            });
            p0 = (CheckBox) v.findViewById(R.id.p0);
    		boolean state0 = Boolean.valueOf(isOutputCh[0]);
    		p0.setChecked(state0);
    		isOutputCh0 = state0;
    		p0.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(p0.isChecked()) { // channel is output
                    	inputsRow0.setVisibility(View.GONE);
                    	isOutputCh0 = true;
                    	isDigCh0 = true;
                    	outputsRow0.setVisibility(View.VISIBLE);                    
                    	out_hiLow0.setVisibility(View.VISIBLE);
                    	rg16.check(R.id.out_digital0);
                		out_freq0.setVisibility(View.GONE);
                    	outFreqLabel0.setVisibility(View.INVISIBLE);
                    	duty_freq0.setVisibility(View.GONE);
                    	outDutyLabel0.setVisibility(View.INVISIBLE);
                    	allDigOut0.setVisibility(View.VISIBLE);
                    	allDigIn0.setVisibility(View.GONE); 
                    	allFreqIn0.setVisibility(View.GONE);
                    	allFreqLabel0.setVisibility(View.INVISIBLE);
                    	allDutyOut0.setVisibility(View.GONE);
                    	allDutyLabel0.setVisibility(View.INVISIBLE);
                    } else { // channel is input
                    	outputsRow0.setVisibility(View.GONE);
                    	isOutputCh0 = false;
                    	isDigCh0 = true;
                    	inputsRow0.setVisibility(View.VISIBLE);
                    	hiLow0.setVisibility(View.VISIBLE);
                    	rg0.check(R.id.digital0);
                    	freq0.setVisibility(View.GONE);
                    	inFreqLabel0.setVisibility(View.INVISIBLE);
                    	allDigIn0.setVisibility(View.VISIBLE);
                    	allDigOut0.setVisibility(View.GONE);
                    	allFreqOut0.setVisibility(View.GONE);
                    	allFreqLabel0.setVisibility(View.INVISIBLE);
                    	allDutyOut0.setVisibility(View.GONE);
                    	allDutyLabel0.setVisibility(View.INVISIBLE);
                     }
                }
            });
    		p1 = (CheckBox) v.findViewById(R.id.p1);
    		boolean state1 = Boolean.valueOf(isOutputCh[1]);
    		p1.setChecked(state1);
    		isOutputCh1 = state1;
    		p1.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(p1.isChecked()) {
                		inputsRow1.setVisibility(View.GONE);
                    	isOutputCh1 = true;
                    	isDigCh1 = true;
                    	outputsRow1.setVisibility(View.VISIBLE);                    
                    	out_hiLow1.setVisibility(View.VISIBLE);
                    	rg17.check(R.id.out_digital1);
                		out_freq1.setVisibility(View.GONE);
                    	outFreqLabel1.setVisibility(View.INVISIBLE);
                    	allDigOut1.setVisibility(View.VISIBLE);
                    	allDigIn1.setVisibility(View.GONE); 
                    	allFreqIn1.setVisibility(View.GONE);
                    	allFreqLabel1.setVisibility(View.INVISIBLE); 
                    	allDutyOut1.setVisibility(View.GONE);
                    	allDutyLabel1.setVisibility(View.INVISIBLE);
                    } else {
                    	outputsRow1.setVisibility(View.GONE);
                    	isOutputCh1 = false;
                    	isDigCh1 = true;
                    	inputsRow1.setVisibility(View.VISIBLE);
                    	hiLow1.setVisibility(View.VISIBLE);
                    	rg1.check(R.id.digital1);
                    	freq1.setVisibility(View.GONE);
                    	inFreqLabel1.setVisibility(View.INVISIBLE);
                    	allDigIn1.setVisibility(View.VISIBLE);
                    	allDigOut1.setVisibility(View.GONE);
                    	allFreqOut1.setVisibility(View.GONE);
                    	allFreqLabel1.setVisibility(View.INVISIBLE);
                    	allDutyOut1.setVisibility(View.GONE);
                    	allDutyLabel1.setVisibility(View.INVISIBLE);
                    }
                }
            });
    		p2 = (CheckBox) v.findViewById(R.id.p2);
    		boolean state2 = Boolean.valueOf(isOutputCh[2]);
    		p2.setChecked(state2);
    		isOutputCh2 = state2;
    		p2.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(p2.isChecked()) {
                		inputsRow2.setVisibility(View.GONE);
                    	isOutputCh2 = true;
                    	isDigCh2 = true;
                    	outputsRow2.setVisibility(View.VISIBLE);                    
                    	out_hiLow2.setVisibility(View.VISIBLE);
                    	rg18.check(R.id.out_digital2);
                		out_freq2.setVisibility(View.GONE);
                    	outFreqLabel2.setVisibility(View.INVISIBLE);
                    	allDigOut2.setVisibility(View.VISIBLE);
                    	allDigIn2.setVisibility(View.GONE); 
                    	allFreqIn2.setVisibility(View.GONE);
                    	allFreqLabel2.setVisibility(View.INVISIBLE);
                    	allDutyOut2.setVisibility(View.GONE);
                    	allDutyLabel2.setVisibility(View.INVISIBLE);
                    } else {
                    	outputsRow2.setVisibility(View.GONE);
                    	isOutputCh2 = false;
                    	isDigCh2 = true;
                    	inputsRow2.setVisibility(View.VISIBLE);
                    	hiLow2.setVisibility(View.VISIBLE);
                    	rg2.check(R.id.digital2);
                    	freq2.setVisibility(View.GONE);
                    	inFreqLabel2.setVisibility(View.INVISIBLE);
                    	allDigIn2.setVisibility(View.VISIBLE);
                    	allDigOut2.setVisibility(View.GONE);
                    	allFreqOut2.setVisibility(View.GONE);
                    	allFreqLabel2.setVisibility(View.INVISIBLE);
                    	allDutyOut2.setVisibility(View.GONE);
                    	allDutyLabel2.setVisibility(View.INVISIBLE);
                    }
                }
            });
    		p3 = (CheckBox) v.findViewById(R.id.p3);
    		boolean state3 = Boolean.valueOf(isOutputCh[3]);
    		p3.setChecked(state3);
    		isOutputCh3 = state3;
    		p3.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(p3.isChecked()) {
                		inputsRow3.setVisibility(View.GONE);
                    	isOutputCh3 = true;
                    	isDigCh3 = true;
                    	outputsRow3.setVisibility(View.VISIBLE);                    
                    	out_hiLow3.setVisibility(View.VISIBLE);
                    	rg19.check(R.id.out_digital3);
                		out_freq3.setVisibility(View.GONE);
                    	outFreqLabel3.setVisibility(View.INVISIBLE);
                    	allDigOut3.setVisibility(View.VISIBLE);
                    	allDigIn3.setVisibility(View.GONE); 
                    	allFreqIn3.setVisibility(View.GONE);
                    	allFreqLabel3.setVisibility(View.INVISIBLE);
                    	allDutyOut3.setVisibility(View.GONE);
                    	allDutyLabel3.setVisibility(View.INVISIBLE);
                    } else {
                    	outputsRow3.setVisibility(View.GONE);
                    	isOutputCh3 = false;
                    	isDigCh3 = true;
                    	inputsRow3.setVisibility(View.VISIBLE);
                    	hiLow3.setVisibility(View.VISIBLE);
                    	rg3.check(R.id.digital3);
                    	freq3.setVisibility(View.GONE);
                    	inFreqLabel3.setVisibility(View.INVISIBLE);
                    	allDigIn3.setVisibility(View.VISIBLE);
                    	allDigOut3.setVisibility(View.GONE);
                    	allFreqOut3.setVisibility(View.GONE);
                    	allFreqLabel3.setVisibility(View.INVISIBLE);
                    	allDutyOut3.setVisibility(View.GONE);
                    	allDutyLabel3.setVisibility(View.INVISIBLE);
                    }
                }
            });
    		p4 = (CheckBox) v.findViewById(R.id.p4);
    		boolean state4 = Boolean.valueOf(isOutputCh[4]);
    		p4.setChecked(state4);
    		isOutputCh4 = state4;
    		p4.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(p4.isChecked()) {
                		inputsRow4.setVisibility(View.GONE);
                    	isOutputCh4 = true;
                    	isDigCh4 = true;
                    	outputsRow4.setVisibility(View.VISIBLE);                    
                    	out_hiLow4.setVisibility(View.VISIBLE);
                    	rg20.check(R.id.out_digital4);
                		out_freq4.setVisibility(View.GONE);
                    	outFreqLabel4.setVisibility(View.INVISIBLE);
                    	allDigOut4.setVisibility(View.VISIBLE);
                    	allDigIn4.setVisibility(View.GONE); 
                    	allFreqIn4.setVisibility(View.GONE);
                    	allFreqLabel4.setVisibility(View.INVISIBLE);
                    	allDutyOut4.setVisibility(View.GONE);
                    	allDutyLabel4.setVisibility(View.INVISIBLE);
                    } else {
                    	outputsRow4.setVisibility(View.GONE);
                    	isOutputCh4 = false;
                    	isDigCh4 = true;
                    	inputsRow4.setVisibility(View.VISIBLE);
                    	hiLow4.setVisibility(View.VISIBLE);
                    	rg4.check(R.id.digital4);
                    	freq4.setVisibility(View.GONE);
                    	inFreqLabel4.setVisibility(View.INVISIBLE);
                    	allDigIn4.setVisibility(View.VISIBLE);
                    	allDigOut4.setVisibility(View.GONE);
                    	allFreqOut4.setVisibility(View.GONE);
                    	allFreqLabel4.setVisibility(View.INVISIBLE);
                    	allDutyOut4.setVisibility(View.GONE);
                    	allDutyLabel4.setVisibility(View.INVISIBLE);
                    }
                }
            });
    		p5 = (CheckBox) v.findViewById(R.id.p5);
    		boolean state5 = Boolean.valueOf(isOutputCh[5]);
    		p5.setChecked(state5);
    		isOutputCh5 = state5;
    		p5.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(p5.isChecked()) {
                		inputsRow5.setVisibility(View.GONE);
                    	isOutputCh5 = true;
                    	isDigCh5 = true;
                    	outputsRow5.setVisibility(View.VISIBLE);                    
                    	out_hiLow5.setVisibility(View.VISIBLE);
                    	rg21.check(R.id.out_digital5);
                		out_freq5.setVisibility(View.GONE);
                    	outFreqLabel5.setVisibility(View.INVISIBLE);
                    	allDigOut5.setVisibility(View.VISIBLE);
                    	allDigIn5.setVisibility(View.GONE); 
                    	allFreqIn5.setVisibility(View.GONE);
                    	allFreqLabel5.setVisibility(View.INVISIBLE);
                    	allDutyOut5.setVisibility(View.GONE);
                    	allDutyLabel5.setVisibility(View.INVISIBLE);
                    } else {
                    	outputsRow5.setVisibility(View.GONE);
                    	isOutputCh5 = false;
                    	isDigCh5 = true;
                    	inputsRow5.setVisibility(View.VISIBLE);
                    	hiLow5.setVisibility(View.VISIBLE);
                    	rg5.check(R.id.digital5);
                    	freq5.setVisibility(View.GONE);
                    	inFreqLabel5.setVisibility(View.INVISIBLE);
                    	allDigIn5.setVisibility(View.VISIBLE);
                    	allDigOut5.setVisibility(View.GONE);
                    	allFreqOut5.setVisibility(View.GONE);
                    	allFreqLabel5.setVisibility(View.INVISIBLE);
                    	allDutyOut5.setVisibility(View.GONE);
                    	allDutyLabel5.setVisibility(View.INVISIBLE);
                    }
                }
            });
    		p6 = (CheckBox) v.findViewById(R.id.p6);
    		boolean state6 = Boolean.valueOf(isOutputCh[6]);
    		p6.setChecked(state6);
    		isOutputCh6 = state6;
    		p6.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(p6.isChecked()) {
                		inputsRow6.setVisibility(View.GONE);
                    	isOutputCh6 = true;
                    	isDigCh6 = true;
                    	outputsRow6.setVisibility(View.VISIBLE);                    
                    	out_hiLow6.setVisibility(View.VISIBLE);
                    	rg22.check(R.id.out_digital6);
                		out_freq6.setVisibility(View.GONE);
                    	outFreqLabel6.setVisibility(View.INVISIBLE);
                    	allDigOut6.setVisibility(View.VISIBLE);
                    	allDigIn6.setVisibility(View.GONE); 
                    	allFreqIn6.setVisibility(View.GONE);
                    	allFreqLabel6.setVisibility(View.INVISIBLE);
                    	allDutyOut6.setVisibility(View.GONE);
                    	allDutyLabel6.setVisibility(View.INVISIBLE);
                    } else {
                    	outputsRow6.setVisibility(View.GONE);
                    	isOutputCh6 = false;
                    	isDigCh6 = true;
                    	inputsRow6.setVisibility(View.VISIBLE);
                    	hiLow6.setVisibility(View.VISIBLE);
                    	rg6.check(R.id.digital6);
                    	freq6.setVisibility(View.GONE);
                    	inFreqLabel6.setVisibility(View.INVISIBLE);
                    	allDigIn6.setVisibility(View.VISIBLE);
                    	allDigOut6.setVisibility(View.GONE);
                    	allFreqOut6.setVisibility(View.GONE);
                    	allFreqLabel6.setVisibility(View.INVISIBLE);
                    	allDutyOut6.setVisibility(View.GONE);
                    	allDutyLabel6.setVisibility(View.INVISIBLE);
                    }
                }
            });
    		p7 = (CheckBox) v.findViewById(R.id.p7);
    		boolean state7 = Boolean.valueOf(isOutputCh[7]);
    		p7.setChecked(state7);
    		isOutputCh7 = state7;
    		p7.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(p7.isChecked()) {
                		inputsRow7.setVisibility(View.GONE);
                    	isOutputCh7 = true;
                    	isDigCh7 = true;
                    	outputsRow7.setVisibility(View.VISIBLE);                    
                    	out_hiLow7.setVisibility(View.VISIBLE);
                    	rg23.check(R.id.out_digital7);
                		out_freq7.setVisibility(View.GONE);
                    	outFreqLabel7.setVisibility(View.INVISIBLE);
                    	allDigOut7.setVisibility(View.VISIBLE);
                    	allDigIn7.setVisibility(View.GONE); 
                    	allFreqIn7.setVisibility(View.GONE);
                    	allFreqLabel7.setVisibility(View.INVISIBLE);
                    	allDutyOut7.setVisibility(View.GONE);
                    	allDutyLabel7.setVisibility(View.INVISIBLE);
                    } else {
                    	outputsRow7.setVisibility(View.GONE);
                    	isOutputCh7 = false;
                    	isDigCh7 = true;
                    	inputsRow7.setVisibility(View.VISIBLE);
                    	hiLow7.setVisibility(View.VISIBLE);
                    	rg7.check(R.id.digital7);
                    	freq7.setVisibility(View.GONE);
                    	inFreqLabel7.setVisibility(View.INVISIBLE);
                    	allDigIn7.setVisibility(View.VISIBLE);
                    	allDigOut7.setVisibility(View.GONE);
                    	allFreqOut7.setVisibility(View.GONE);
                    	allFreqLabel7.setVisibility(View.INVISIBLE);
                    	allDutyOut7.setVisibility(View.GONE);
                    	allDutyLabel7.setVisibility(View.INVISIBLE);
                    }
                }
            });
    		p8 = (CheckBox) v.findViewById(R.id.p8);
    		boolean state8 = Boolean.valueOf(isOutputCh[8]);
    		p8.setChecked(state8);
    		isOutputCh8 = state8;
    		p8.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(p8.isChecked()) {
                		inputsRow8.setVisibility(View.GONE);
                    	isOutputCh8 = true;
                    	isDigCh8 = true;
                    	outputsRow8.setVisibility(View.VISIBLE);                    
                    	out_hiLow8.setVisibility(View.VISIBLE);
                    	rg24.check(R.id.out_digital8);
                		out_freq8.setVisibility(View.GONE);
                    	outFreqLabel8.setVisibility(View.INVISIBLE);
                    	allDigOut8.setVisibility(View.VISIBLE);
                    	allDigIn8.setVisibility(View.GONE); 
                    	allFreqIn8.setVisibility(View.GONE);
                    	allFreqLabel8.setVisibility(View.INVISIBLE);
                    	allDutyOut8.setVisibility(View.GONE);
                    	allDutyLabel8.setVisibility(View.INVISIBLE);
                    } else {
                    	outputsRow8.setVisibility(View.GONE);
                    	isOutputCh8 = false;
                    	isDigCh8 = true;
                    	inputsRow8.setVisibility(View.VISIBLE);
                    	hiLow8.setVisibility(View.VISIBLE);
                    	rg8.check(R.id.digital8);
                    	freq8.setVisibility(View.GONE);
                    	inFreqLabel8.setVisibility(View.INVISIBLE);
                    	allDigIn8.setVisibility(View.VISIBLE);
                    	allDigOut8.setVisibility(View.GONE);
                    	allFreqOut8.setVisibility(View.GONE);
                    	allFreqLabel8.setVisibility(View.INVISIBLE);
                    	allDutyOut8.setVisibility(View.GONE);
                    	allDutyLabel8.setVisibility(View.INVISIBLE);
                    }
                }
            });
    		p9 = (CheckBox) v.findViewById(R.id.p9);
    		boolean state9 = Boolean.valueOf(isOutputCh[9]);
    		p9.setChecked(state9);
    		isOutputCh9 = state9;
    		p9.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(p9.isChecked()) {
                		inputsRow9.setVisibility(View.GONE);
                    	isOutputCh9 = true;
                    	isDigCh9 = true;
                    	outputsRow9.setVisibility(View.VISIBLE);                    
                    	out_hiLow9.setVisibility(View.VISIBLE);
                    	rg25.check(R.id.out_digital9);
                		out_freq9.setVisibility(View.GONE);
                    	outFreqLabel9.setVisibility(View.INVISIBLE);
                    	allDigOut9.setVisibility(View.VISIBLE);
                    	allDigIn9.setVisibility(View.GONE); 
                    	allFreqIn9.setVisibility(View.GONE);
                    	allFreqLabel9.setVisibility(View.INVISIBLE);
                    	allDutyOut9.setVisibility(View.GONE);
                    	allDutyLabel9.setVisibility(View.INVISIBLE);
                    } else {
                    	outputsRow9.setVisibility(View.GONE);
                    	isOutputCh9 = false;
                    	isDigCh9 = true;
                    	inputsRow9.setVisibility(View.VISIBLE);
                    	hiLow9.setVisibility(View.VISIBLE);
                    	rg9.check(R.id.digital9);
                    	freq9.setVisibility(View.GONE);
                    	inFreqLabel9.setVisibility(View.INVISIBLE);
                    	allDigIn9.setVisibility(View.VISIBLE);
                    	allDigOut9.setVisibility(View.GONE);
                    	allFreqOut9.setVisibility(View.GONE);
                    	allFreqLabel9.setVisibility(View.INVISIBLE);
                    	allDutyOut9.setVisibility(View.GONE);
                    	allDutyLabel9.setVisibility(View.INVISIBLE);
                    }
                }
            });
    		p10 = (CheckBox) v.findViewById(R.id.p10);
    		boolean state10 = Boolean.valueOf(isOutputCh[10]);
    		p10.setChecked(state10);
    		isOutputCh10 = state10;
    		p10.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(p10.isChecked()) {
                		inputsRow10.setVisibility(View.GONE);
                    	isOutputCh10 = true;
                    	isDigCh10 = true;
                    	outputsRow10.setVisibility(View.VISIBLE);                    
                    	out_hiLow10.setVisibility(View.VISIBLE);
                    	rg26.check(R.id.out_digital10);
                		out_freq10.setVisibility(View.GONE);
                    	outFreqLabel10.setVisibility(View.INVISIBLE);
                    	allDigOut10.setVisibility(View.VISIBLE);
                    	allDigIn10.setVisibility(View.GONE); 
                    	allFreqIn10.setVisibility(View.GONE);
                    	allFreqLabel10.setVisibility(View.INVISIBLE);
                    	allDutyOut10.setVisibility(View.GONE);
                    	allDutyLabel10.setVisibility(View.INVISIBLE);
                    } else {
                    	outputsRow10.setVisibility(View.GONE);
                    	isOutputCh10 = false;
                    	isDigCh10 = true;
                    	inputsRow10.setVisibility(View.VISIBLE);
                    	hiLow10.setVisibility(View.VISIBLE);
                    	rg10.check(R.id.digital10);
                    	freq10.setVisibility(View.GONE);
                    	inFreqLabel10.setVisibility(View.INVISIBLE);
                    	allDigIn10.setVisibility(View.VISIBLE);
                    	allDigOut10.setVisibility(View.GONE);
                    	allFreqOut10.setVisibility(View.GONE);
                    	allFreqLabel10.setVisibility(View.INVISIBLE);
                    	allDutyOut10.setVisibility(View.GONE);
                    	allDutyLabel10.setVisibility(View.INVISIBLE);
                    }
                }
            });
    		p11 = (CheckBox) v.findViewById(R.id.p11);
    		boolean state11 = Boolean.valueOf(isOutputCh[11]);
    		p11.setChecked(state11);
    		isOutputCh11 = state11;
    		p11.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(p11.isChecked()) {
                		inputsRow11.setVisibility(View.GONE);
                    	isOutputCh11 = true;
                    	isDigCh11 = true;
                    	outputsRow11.setVisibility(View.VISIBLE);                    
                    	out_hiLow11.setVisibility(View.VISIBLE);
                    	rg27.check(R.id.out_digital11);
                		out_freq11.setVisibility(View.GONE);
                    	outFreqLabel11.setVisibility(View.INVISIBLE);
                    	allDigOut11.setVisibility(View.VISIBLE);
                    	allDigIn11.setVisibility(View.GONE); 
                    	allFreqIn11.setVisibility(View.GONE);
                    	allFreqLabel11.setVisibility(View.INVISIBLE);
                    	allDutyOut11.setVisibility(View.GONE);
                    	allDutyLabel11.setVisibility(View.INVISIBLE);
                    } else {
                    	outputsRow11.setVisibility(View.GONE);
                    	isOutputCh11 = false;
                    	isDigCh11 = true;
                    	inputsRow11.setVisibility(View.VISIBLE);
                    	hiLow11.setVisibility(View.VISIBLE);
                    	rg11.check(R.id.digital11);
                    	freq11.setVisibility(View.GONE);
                    	inFreqLabel11.setVisibility(View.INVISIBLE);
                    	allDigIn11.setVisibility(View.VISIBLE);
                    	allDigOut11.setVisibility(View.GONE);
                    	allFreqOut11.setVisibility(View.GONE);
                    	allFreqLabel11.setVisibility(View.INVISIBLE);
                    	allDutyOut11.setVisibility(View.GONE);
                    	allDutyLabel11.setVisibility(View.INVISIBLE);
                    }
                }
            });
    		p12 = (CheckBox) v.findViewById(R.id.p12);
    		boolean state12 = Boolean.valueOf(isOutputCh[12]);
    		p12.setChecked(state12);
    		isOutputCh12 = state12;
    		p12.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(p12.isChecked()) {
                		inputsRow12.setVisibility(View.GONE);
                    	isOutputCh12 = true;
                    	isDigCh12 = true;
                    	outputsRow12.setVisibility(View.VISIBLE);                    
                    	out_hiLow12.setVisibility(View.VISIBLE);
                    	rg28.check(R.id.out_digital12);
                		out_freq12.setVisibility(View.GONE);
                    	outFreqLabel12.setVisibility(View.INVISIBLE);
                    	allDigOut12.setVisibility(View.VISIBLE);
                    	allDigIn12.setVisibility(View.GONE); 
                    	allFreqIn12.setVisibility(View.GONE);
                    	allFreqLabel12.setVisibility(View.INVISIBLE);
                    	allDutyOut12.setVisibility(View.GONE);
                    	allDutyLabel12.setVisibility(View.INVISIBLE);
                    } else {
                    	outputsRow12.setVisibility(View.GONE);
                    	isOutputCh12 = false;
                    	isDigCh12 = true;
                    	inputsRow12.setVisibility(View.VISIBLE);
                    	hiLow12.setVisibility(View.VISIBLE);
                    	rg12.check(R.id.digital12);
                    	freq12.setVisibility(View.GONE);
                    	inFreqLabel12.setVisibility(View.INVISIBLE);
                    	allDigIn12.setVisibility(View.VISIBLE);
                    	allDigOut12.setVisibility(View.GONE);
                    	allFreqOut12.setVisibility(View.GONE);
                    	allFreqLabel12.setVisibility(View.INVISIBLE);
                    	allDutyOut12.setVisibility(View.GONE);
                    	allDutyLabel12.setVisibility(View.INVISIBLE);
                    }
                }
            });
    		p13 = (CheckBox) v.findViewById(R.id.p13);
    		boolean state13 = Boolean.valueOf(isOutputCh[13]);
    		p13.setChecked(state13);
    		isOutputCh13 = state13;
    		p13.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(p13.isChecked()) {
                		inputsRow13.setVisibility(View.GONE);
                    	isOutputCh13 = true;
                    	isDigCh13 = true;
                    	outputsRow13.setVisibility(View.VISIBLE);                    
                    	out_hiLow13.setVisibility(View.VISIBLE);
                    	rg29.check(R.id.out_digital13);
                		out_freq13.setVisibility(View.GONE);
                    	outFreqLabel13.setVisibility(View.INVISIBLE);
                    	allDigOut13.setVisibility(View.VISIBLE);
                    	allDigIn13.setVisibility(View.GONE); 
                    	allFreqIn13.setVisibility(View.GONE);
                    	allFreqLabel13.setVisibility(View.INVISIBLE);
                    	allDutyOut13.setVisibility(View.GONE);
                    	allDutyLabel13.setVisibility(View.INVISIBLE);
                    } else {
                    	outputsRow13.setVisibility(View.GONE);
                    	isOutputCh13 = false;
                    	isDigCh13 = true;
                    	inputsRow13.setVisibility(View.VISIBLE);
                    	hiLow13.setVisibility(View.VISIBLE);
                    	rg13.check(R.id.digital13);
                    	freq13.setVisibility(View.GONE);
                    	inFreqLabel13.setVisibility(View.INVISIBLE);
                    	allDigIn13.setVisibility(View.VISIBLE);
                    	allDigOut13.setVisibility(View.GONE);
                    	allFreqOut13.setVisibility(View.GONE);
                    	allFreqLabel13.setVisibility(View.INVISIBLE);
                    	allDutyOut13.setVisibility(View.GONE);
                    	allDutyLabel13.setVisibility(View.INVISIBLE);
                    }
                }
            });
    		p14 = (CheckBox) v.findViewById(R.id.p14);
    		boolean state14 = Boolean.valueOf(isOutputCh[14]);
    		p14.setChecked(state14);
    		isOutputCh14 = state14;
    		p14.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(p14.isChecked()) {
                		inputsRow14.setVisibility(View.GONE);
                    	isOutputCh14 = true;
                    	isDigCh14 = true;
                    	outputsRow14.setVisibility(View.VISIBLE);                    
                    	out_hiLow14.setVisibility(View.VISIBLE);
                    	rg30.check(R.id.out_digital14);
                		out_freq14.setVisibility(View.GONE);
                    	outFreqLabel14.setVisibility(View.INVISIBLE);
                    	allDigOut14.setVisibility(View.VISIBLE);
                    	allDigIn14.setVisibility(View.GONE); 
                    	allFreqIn14.setVisibility(View.GONE);
                    	allFreqLabel14.setVisibility(View.INVISIBLE);
                    	allDutyOut14.setVisibility(View.GONE);
                    	allDutyLabel14.setVisibility(View.INVISIBLE);
                    } else {
                    	outputsRow14.setVisibility(View.GONE);
                    	isOutputCh14 = false;
                    	isDigCh14 = true;
                    	inputsRow14.setVisibility(View.VISIBLE);
                    	hiLow14.setVisibility(View.VISIBLE);
                    	rg14.check(R.id.digital14);
                    	freq14.setVisibility(View.GONE);
                    	inFreqLabel14.setVisibility(View.INVISIBLE);
                    	allDigIn14.setVisibility(View.VISIBLE);
                    	allDigOut14.setVisibility(View.GONE);
                    	allFreqOut14.setVisibility(View.GONE);
                    	allFreqLabel14.setVisibility(View.INVISIBLE);
                    	allDutyOut14.setVisibility(View.GONE);
                    	allDutyLabel14.setVisibility(View.INVISIBLE);
                    }
                }
            });
    		p15 = (CheckBox) v.findViewById(R.id.p15);
    		boolean state15 = Boolean.valueOf(isOutputCh[15]);
    		p15.setChecked(state15);
    		isOutputCh15 = state15;
    		p15.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(p15.isChecked()) {
                		inputsRow15.setVisibility(View.GONE);
                    	isOutputCh15 = true;
                    	isDigCh15 = true;
                    	outputsRow15.setVisibility(View.VISIBLE);                    
                    	out_hiLow15.setVisibility(View.VISIBLE);
                    	rg31.check(R.id.out_digital15);
                		out_freq15.setVisibility(View.GONE);
                    	outFreqLabel15.setVisibility(View.INVISIBLE);
                    	allDigOut15.setVisibility(View.VISIBLE);
                    	allDigIn15.setVisibility(View.GONE); 
                    	allFreqIn15.setVisibility(View.GONE);
                    	allFreqLabel15.setVisibility(View.INVISIBLE);
                    	allDutyOut15.setVisibility(View.GONE);
                    	allDutyLabel15.setVisibility(View.INVISIBLE);
                    } else {
                    	outputsRow15.setVisibility(View.GONE);
                    	isOutputCh15 = false;
                    	isDigCh15 = true;
                    	inputsRow15.setVisibility(View.VISIBLE);
                    	hiLow15.setVisibility(View.VISIBLE);
                    	rg15.check(R.id.digital15);
                    	freq15.setVisibility(View.GONE);
                    	inFreqLabel15.setVisibility(View.INVISIBLE);
                    	allDigIn15.setVisibility(View.VISIBLE);
                    	allDigOut15.setVisibility(View.GONE);
                    	allFreqOut15.setVisibility(View.GONE);
                    	allFreqLabel15.setVisibility(View.INVISIBLE);
                    	allDutyOut15.setVisibility(View.GONE);
                    	allDutyLabel15.setVisibility(View.INVISIBLE);
                    }
                }
            });
    		//((AndroiDAQTCPMain) context).showSetupToast();
            break;
        case 1:
            //resId = R.layout.inputs;
        	resId = R.layout.inputs;
        	v = inflater.inflate(resId, null, false);  
        	inputSetRun = (Button)v.findViewById(R.id.read_inputs);
        	inputSV = (ScrollView)v.findViewById(R.id.scrollViewInputs);
        	inputSV.setScrollbarFadingEnabled(false);
        	inputSetRun.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                	int connected = ((AndroiDAQTCPMain)context).btState();
                	if ( connected != 3) {
                        Toast.makeText(context, R.string.not_connected, Toast.LENGTH_SHORT).show();
                        runInputs = false;
                    } else {
                    	runInputs = true;
                    	setProp();
                    }
                }
            });
        	inputContRun = (Button)v.findViewById(R.id.read_cont_inputs);
        	inputContRun.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                	//setPropAndRead();    
                	//TODO setup input reads
                	//((AndroiDAQTCPMain) context).getInputs(true);
                	int connected = ((AndroiDAQTCPMain)context).btState();
                	if ( connected != 3) {
                        Toast.makeText(context, R.string.not_connected, Toast.LENGTH_SHORT).show();
                        runContInputs = false;
                        inputContRun.setText("Continuous Read Input from AndroiDAQ");
                    } else {
                    	if (!runContInputs) {
                        	inputContRun.setText("Stop Cont. Read Input from AndroiDAQ");
                        	runContInputs = true;
                        	setProp();
                    	} else {
                    		inputContRun.setText("Continuous Read Input from AndroiDAQ");
                    		runContInputs = false;
                        	stopContInput();
                    	}
                    }
                }
            });
            inputsRow0 = (TableRow) v.findViewById(R.id.inputsRow1);
            if (isOutputCh[0]) {
            	inputsRow0.setVisibility(View.GONE);
            }
            hiLow0 = (RadioButton)v.findViewById(R.id.hi_low0);
            freq0 = (TextView)v.findViewById(R.id.input_freq0);
            inFreqLabel0 = (TextView)v.findViewById(R.id.infreq_label0);
            rg0 = (RadioGroup) v.findViewById(R.id.radioGroup0);
            if (isDigCh[0]) { 
            	hiLow0.setVisibility(View.VISIBLE);
            	freq0.setVisibility(View.GONE);
            	isDigCh0 = true;
            	inFreqLabel0.setVisibility(View.INVISIBLE);
            	rg0.check(R.id.digital0);
            } else {
            	hiLow0.setVisibility(View.GONE);
                freq0.setVisibility(View.VISIBLE);
                isDigCh0 = false;
                inFreqLabel0.setVisibility(View.VISIBLE);
                rg0.check(R.id.count0);
            }
            rg0.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.digital0) { // if checked channel is digital
                		  hiLow0.setVisibility(View.VISIBLE);
                		  isDigCh0 = true;
                		  freq0.setVisibility(View.GONE); 
                          inFreqLabel0.setVisibility(View.INVISIBLE);
                		  allDigIn0.setVisibility(View.VISIBLE);
                		  allFreqIn0.setVisibility(View.GONE);
                		  allFreqLabel0.setVisibility(View.INVISIBLE);

                      } else {
                    	  hiLow0.setVisibility(View.GONE);
                    	  isDigCh0 = false;
                		  freq0.setVisibility(View.VISIBLE);
                          inFreqLabel0.setVisibility(View.VISIBLE);
                		  allDigIn0.setVisibility(View.GONE); 
                		  allFreqIn0.setVisibility(View.VISIBLE);
                		  allFreqLabel0.setVisibility(View.VISIBLE);
                		  
                      }
                  }
            });
    		inputsRow1 = (TableRow) v.findViewById(R.id.inputsRow2);
    		if (isOutputCh[1]) {
    			inputsRow1.setVisibility(View.GONE);
    		}
    		hiLow1 = (RadioButton)v.findViewById(R.id.hi_low1);
            freq1 = (TextView)v.findViewById(R.id.input_freq1);
            inFreqLabel1 = (TextView)v.findViewById(R.id.infreq_label1);
            rg1 = (RadioGroup) v.findViewById(R.id.radioGroup1);
            if (isDigCh[1]) {
            	hiLow1.setVisibility(View.VISIBLE);
            	freq1.setVisibility(View.GONE);
            	isDigCh1 = true;
            	inFreqLabel1.setVisibility(View.INVISIBLE);
            	rg1.check(R.id.digital1);
            } else {
            	hiLow1.setVisibility(View.GONE);
                freq1.setVisibility(View.VISIBLE);
                isDigCh1 = false;
                inFreqLabel1.setVisibility(View.VISIBLE);
                rg1.check(R.id.count1);
            }
            rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.digital1) {
                		  hiLow1.setVisibility(View.VISIBLE);
                		  isDigCh1 = true;
                		  freq1.setVisibility(View.GONE);
                		  inFreqLabel1.setVisibility(View.INVISIBLE);
                		  allDigIn1.setVisibility(View.VISIBLE);
                		  allFreqIn1.setVisibility(View.GONE);
                		  allFreqLabel1.setVisibility(View.INVISIBLE);
                      } else {
                    	  hiLow1.setVisibility(View.GONE);
                    	  isDigCh1 = false;
                		  freq1.setVisibility(View.VISIBLE);
                		  inFreqLabel1.setVisibility(View.VISIBLE);
                		  allDigIn1.setVisibility(View.GONE); 
                		  allFreqIn1.setVisibility(View.VISIBLE);
                		  allFreqLabel1.setVisibility(View.VISIBLE);
                      }
                  }
            });
    		inputsRow2 = (TableRow) v.findViewById(R.id.inputsRow3);
    		if (isOutputCh[2]) {
    			inputsRow2.setVisibility(View.GONE);
    		}
            hiLow2 = (RadioButton)v.findViewById(R.id.hi_low2);
            freq2 = (TextView)v.findViewById(R.id.input_freq2);
            inFreqLabel2 = (TextView)v.findViewById(R.id.infreq_label2);
            rg2 = (RadioGroup) v.findViewById(R.id.radioGroup2);
            if (isDigCh[2]) {
            	hiLow2.setVisibility(View.VISIBLE);
            	freq2.setVisibility(View.GONE);
            	isDigCh2 = true;
            	inFreqLabel2.setVisibility(View.INVISIBLE);
            	rg2.check(R.id.digital2);
            } else {
            	hiLow2.setVisibility(View.GONE);
                freq2.setVisibility(View.VISIBLE);
                isDigCh2 = false;
                inFreqLabel2.setVisibility(View.VISIBLE);
                rg2.check(R.id.count2);
            }
            rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.digital2) {
                		  hiLow2.setVisibility(View.VISIBLE);
                		  isDigCh2 = true;
                		  freq2.setVisibility(View.GONE);
                		  inFreqLabel2.setVisibility(View.INVISIBLE);
                		  allDigIn2.setVisibility(View.VISIBLE);
                		  allFreqIn2.setVisibility(View.GONE);
                		  allFreqLabel2.setVisibility(View.INVISIBLE);
                      } else {
                    	  hiLow2.setVisibility(View.GONE);
                    	  isDigCh2 = false;
                		  freq2.setVisibility(View.VISIBLE);
                		  inFreqLabel2.setVisibility(View.VISIBLE);
                		  allDigIn2.setVisibility(View.GONE); 
                		  allFreqIn2.setVisibility(View.VISIBLE);
                		  allFreqLabel2.setVisibility(View.VISIBLE);
                      }
                  }
            });
    		inputsRow3 = (TableRow) v.findViewById(R.id.inputsRow4);
    		if (isOutputCh[3]) {
    			inputsRow3.setVisibility(View.GONE);
    		}
            hiLow3 = (RadioButton)v.findViewById(R.id.hi_low3);
            freq3 = (TextView)v.findViewById(R.id.input_freq3);
            inFreqLabel3 = (TextView)v.findViewById(R.id.infreq_label3);
            rg3 = (RadioGroup) v.findViewById(R.id.radioGroup3);
            if (isDigCh[3]) {
            	hiLow3.setVisibility(View.VISIBLE);
            	freq3.setVisibility(View.GONE);
            	isDigCh3 = true;
            	inFreqLabel3.setVisibility(View.INVISIBLE);
            	rg3.check(R.id.digital3);
            } else {
            	hiLow3.setVisibility(View.GONE);
                freq3.setVisibility(View.VISIBLE);
                isDigCh3 = false;
                inFreqLabel3.setVisibility(View.VISIBLE);
                rg3.check(R.id.count3);
            }
            rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.digital3) {
                		  hiLow3.setVisibility(View.VISIBLE);
                		  isDigCh3 = true;
                		  freq3.setVisibility(View.GONE);
                		  inFreqLabel3.setVisibility(View.INVISIBLE);
                		  allDigIn3.setVisibility(View.VISIBLE);
                		  allFreqIn3.setVisibility(View.GONE);
                		  allFreqLabel3.setVisibility(View.INVISIBLE);
                      } else {
                    	  hiLow3.setVisibility(View.GONE);
                    	  isDigCh3 = false;
                		  freq3.setVisibility(View.VISIBLE);
                		  inFreqLabel3.setVisibility(View.VISIBLE);
                		  allDigIn3.setVisibility(View.GONE); 
                		  allFreqIn3.setVisibility(View.VISIBLE);
                		  allFreqLabel3.setVisibility(View.VISIBLE);
                      }
                  }
            });
            inputsRow4 = (TableRow) v.findViewById(R.id.inputsRow5);
            if (isOutputCh[4]) {
    			inputsRow4.setVisibility(View.GONE);
    		}
            hiLow4 = (RadioButton)v.findViewById(R.id.hi_low4);
            freq4 = (TextView)v.findViewById(R.id.input_freq4);
            inFreqLabel4 = (TextView)v.findViewById(R.id.infreq_label4);
            rg4 = (RadioGroup) v.findViewById(R.id.radioGroup4);
            if (isDigCh[4]) {
            	hiLow4.setVisibility(View.VISIBLE);
            	freq4.setVisibility(View.GONE);
            	isDigCh4 = true;
            	inFreqLabel4.setVisibility(View.INVISIBLE);
            	rg4.check(R.id.digital4);
            } else {
            	hiLow4.setVisibility(View.GONE);
                freq4.setVisibility(View.VISIBLE);
                isDigCh4 = false;
                inFreqLabel4.setVisibility(View.VISIBLE);
                rg4.check(R.id.count4);
            }
            rg4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.digital4) {
                		  hiLow4.setVisibility(View.VISIBLE);
                		  isDigCh4 = true;
                		  freq4.setVisibility(View.GONE);
                		  inFreqLabel4.setVisibility(View.INVISIBLE);
                		  allDigIn4.setVisibility(View.VISIBLE);
                		  allFreqIn4.setVisibility(View.GONE);
                		  allFreqLabel4.setVisibility(View.INVISIBLE);
                      } else {
                    	  hiLow4.setVisibility(View.GONE);
                    	  isDigCh4 = false;
                		  freq4.setVisibility(View.VISIBLE);
                		  inFreqLabel4.setVisibility(View.VISIBLE);
                		  allDigIn4.setVisibility(View.GONE); 
                		  allFreqIn4.setVisibility(View.VISIBLE);
                		  allFreqLabel4.setVisibility(View.VISIBLE);
                      }
                  }
            });
    		inputsRow5 = (TableRow) v.findViewById(R.id.inputsRow6);
    		if (isOutputCh[5]) {
    			inputsRow5.setVisibility(View.GONE);
    		}
            hiLow5 = (RadioButton)v.findViewById(R.id.hi_low5);
            freq5 = (TextView)v.findViewById(R.id.input_freq5);
            inFreqLabel5 = (TextView)v.findViewById(R.id.infreq_label5);
            rg5 = (RadioGroup) v.findViewById(R.id.radioGroup5);
            if (isDigCh[5]) {
            	hiLow5.setVisibility(View.VISIBLE);
            	freq5.setVisibility(View.GONE);
            	isDigCh5 = true;
            	inFreqLabel5.setVisibility(View.INVISIBLE);
            	rg5.check(R.id.digital5);
            } else {
            	hiLow5.setVisibility(View.GONE);
                freq5.setVisibility(View.VISIBLE);
                isDigCh5 = false;
                inFreqLabel5.setVisibility(View.VISIBLE);
                rg5.check(R.id.count5);
            }
            rg5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.digital5) {
                		  hiLow5.setVisibility(View.VISIBLE);
                		  isDigCh5 = true;
                		  freq5.setVisibility(View.GONE);
                		  inFreqLabel5.setVisibility(View.INVISIBLE);
                		  allDigIn5.setVisibility(View.VISIBLE);
                		  allFreqIn5.setVisibility(View.GONE);
                		  allFreqLabel5.setVisibility(View.INVISIBLE);
                      } else {
                    	  hiLow5.setVisibility(View.GONE);
                    	  isDigCh5 = false;
                		  freq5.setVisibility(View.VISIBLE);
                		  inFreqLabel5.setVisibility(View.VISIBLE);
                		  allDigIn5.setVisibility(View.GONE); 
                		  allFreqIn5.setVisibility(View.VISIBLE);
                		  allFreqLabel5.setVisibility(View.VISIBLE);
                      }
                  }
            });
    		inputsRow6 = (TableRow) v.findViewById(R.id.inputsRow7);
    		if (isOutputCh[6]) {
    			inputsRow6.setVisibility(View.GONE);
    		}
            hiLow6 = (RadioButton)v.findViewById(R.id.hi_low6);
            freq6 = (TextView)v.findViewById(R.id.input_freq6);
            inFreqLabel6 = (TextView)v.findViewById(R.id.infreq_label6);
            rg6 = (RadioGroup) v.findViewById(R.id.radioGroup6);
            if (isDigCh[6]) {
            	hiLow6.setVisibility(View.VISIBLE);
            	freq6.setVisibility(View.GONE);
            	isDigCh6 = true;
            	inFreqLabel6.setVisibility(View.INVISIBLE);
            	rg6.check(R.id.digital6);
            } else {
            	hiLow6.setVisibility(View.GONE);
                freq6.setVisibility(View.VISIBLE);
                isDigCh6 = false;
                inFreqLabel6.setVisibility(View.VISIBLE);
                rg6.check(R.id.count6);
            }
            rg6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.digital6) {
                		  hiLow6.setVisibility(View.VISIBLE);
                		  isDigCh6 = true;
                		  freq6.setVisibility(View.GONE);
                		  inFreqLabel6.setVisibility(View.INVISIBLE);
                		  allDigIn6.setVisibility(View.VISIBLE);
                		  allFreqIn6.setVisibility(View.GONE);
                		  allFreqLabel6.setVisibility(View.INVISIBLE);
                      } else {
                    	  hiLow6.setVisibility(View.GONE);
                    	  isDigCh6 = false;
                		  freq6.setVisibility(View.VISIBLE);
                		  inFreqLabel6.setVisibility(View.VISIBLE);
                		  allDigIn6.setVisibility(View.GONE); 
                		  allFreqIn6.setVisibility(View.VISIBLE);
                		  allFreqLabel6.setVisibility(View.VISIBLE);
                      }
                  }
            });
    		inputsRow7 = (TableRow) v.findViewById(R.id.inputsRow8);
    		if (isOutputCh[7]) {
    			inputsRow7.setVisibility(View.GONE);
    		}
            hiLow7 = (RadioButton)v.findViewById(R.id.hi_low7);
            freq7 = (TextView)v.findViewById(R.id.input_freq7);
            inFreqLabel7 = (TextView)v.findViewById(R.id.infreq_label7);
            rg7 = (RadioGroup) v.findViewById(R.id.radioGroup7);
            if (isDigCh[7]) {
            	hiLow7.setVisibility(View.VISIBLE);
            	freq7.setVisibility(View.GONE);
            	isDigCh7 = true;
            	inFreqLabel7.setVisibility(View.INVISIBLE);
            	rg7.check(R.id.digital7);
            } else {
            	hiLow7.setVisibility(View.GONE);
                freq7.setVisibility(View.VISIBLE);
                isDigCh7 = false;
                inFreqLabel7.setVisibility(View.VISIBLE);
                rg7.check(R.id.count7);
            }
            rg7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.digital7) {
                		  hiLow7.setVisibility(View.VISIBLE);
                		  isDigCh7 = true;
                		  freq7.setVisibility(View.GONE);
                		  inFreqLabel7.setVisibility(View.INVISIBLE);
                		  allDigIn7.setVisibility(View.VISIBLE);
                		  allFreqIn7.setVisibility(View.GONE);
                		  allFreqLabel7.setVisibility(View.INVISIBLE);
                      } else {
                    	  hiLow7.setVisibility(View.GONE);
                    	  isDigCh7 = false;
                		  freq7.setVisibility(View.VISIBLE);
                		  inFreqLabel7.setVisibility(View.VISIBLE);
                		  allDigIn7.setVisibility(View.GONE); 
                		  allFreqIn7.setVisibility(View.VISIBLE);
                		  allFreqLabel7.setVisibility(View.VISIBLE);
                      }
                  }
            });
            inputsRow8 = (TableRow) v.findViewById(R.id.inputsRow9);
            if (isOutputCh[8]) {
    			inputsRow8.setVisibility(View.GONE);
    		}
            hiLow8 = (RadioButton)v.findViewById(R.id.hi_low8);
            freq8 = (TextView)v.findViewById(R.id.input_freq8);
            inFreqLabel8 = (TextView)v.findViewById(R.id.infreq_label8);
            rg8 = (RadioGroup) v.findViewById(R.id.radioGroup8);
            if (isDigCh[8]) {
            	hiLow8.setVisibility(View.VISIBLE);
            	freq8.setVisibility(View.GONE);
            	isDigCh8 = true;
            	inFreqLabel8.setVisibility(View.INVISIBLE);
            	rg8.check(R.id.digital8);
            } else {
            	hiLow8.setVisibility(View.GONE);
                freq8.setVisibility(View.VISIBLE);
                isDigCh8 = false;
                inFreqLabel8.setVisibility(View.VISIBLE);
                rg8.check(R.id.count8);
            }
            rg8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.digital8) {
                		  hiLow8.setVisibility(View.VISIBLE);
                		  isDigCh8 = true;
                		  freq8.setVisibility(View.GONE);
                		  inFreqLabel8.setVisibility(View.INVISIBLE);
                		  allDigIn8.setVisibility(View.VISIBLE);
                		  allFreqIn8.setVisibility(View.GONE);
                		  allFreqLabel8.setVisibility(View.INVISIBLE);
                      } else {
                    	  hiLow8.setVisibility(View.GONE);
                    	  isDigCh8 = false;
                		  freq8.setVisibility(View.VISIBLE);
                		  inFreqLabel8.setVisibility(View.VISIBLE);
                		  allDigIn8.setVisibility(View.GONE); 
                		  allFreqIn8.setVisibility(View.VISIBLE);
                		  allFreqLabel8.setVisibility(View.VISIBLE);
                      }
                  }
            });
    		inputsRow9 = (TableRow) v.findViewById(R.id.inputsRow10);
    		if (isOutputCh[9]) {
    			inputsRow9.setVisibility(View.GONE);
    		}
            hiLow9 = (RadioButton)v.findViewById(R.id.hi_low9);
            freq9 = (TextView)v.findViewById(R.id.input_freq9);
            inFreqLabel9 = (TextView)v.findViewById(R.id.infreq_label9);
            rg9 = (RadioGroup) v.findViewById(R.id.radioGroup9);
            if (isDigCh[9]) {
            	hiLow9.setVisibility(View.VISIBLE);
            	freq9.setVisibility(View.GONE);
            	isDigCh9 = true;
            	inFreqLabel9.setVisibility(View.INVISIBLE);
            	rg9.check(R.id.digital9);
            } else {
            	hiLow9.setVisibility(View.GONE);
                freq9.setVisibility(View.VISIBLE);
                isDigCh9 = false;
                inFreqLabel9.setVisibility(View.VISIBLE);
                rg9.check(R.id.count9);
            }
            rg9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.digital9) {
                		  hiLow9.setVisibility(View.VISIBLE);
                		  isDigCh9 = true;
                		  freq9.setVisibility(View.GONE);
                		  inFreqLabel9.setVisibility(View.INVISIBLE);
                		  allDigIn9.setVisibility(View.VISIBLE);
                		  allFreqIn9.setVisibility(View.GONE);
                		  allFreqLabel9.setVisibility(View.INVISIBLE);
                      } else {
                    	  hiLow9.setVisibility(View.GONE);
                    	  isDigCh9 = false;
                		  freq9.setVisibility(View.VISIBLE);
                		  inFreqLabel9.setVisibility(View.VISIBLE);
                		  allDigIn9.setVisibility(View.GONE); 
                		  allFreqIn9.setVisibility(View.VISIBLE);
                		  allFreqLabel9.setVisibility(View.VISIBLE);
                      }
                  }
            });
    		inputsRow10 = (TableRow) v.findViewById(R.id.inputsRow11);
    		if (isOutputCh[10] ) {
    			inputsRow10.setVisibility(View.GONE);
    		}
            hiLow10 = (RadioButton)v.findViewById(R.id.hi_low10);
            freq10 = (TextView)v.findViewById(R.id.input_freq10);
            inFreqLabel10 = (TextView)v.findViewById(R.id.infreq_label10);
            rg10 = (RadioGroup) v.findViewById(R.id.radioGroup10);
            if (isDigCh[10]) {
            	hiLow10.setVisibility(View.VISIBLE);
            	freq10.setVisibility(View.GONE);
            	isDigCh10 = true;
            	inFreqLabel10.setVisibility(View.INVISIBLE);
            	rg10.check(R.id.digital10);
            } else {
            	hiLow10.setVisibility(View.GONE);
                freq10.setVisibility(View.VISIBLE);
                isDigCh10 = false;
                inFreqLabel10.setVisibility(View.VISIBLE);
                rg10.check(R.id.count10);
            }
            rg10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.digital10) {
                		  hiLow10.setVisibility(View.VISIBLE);
                		  isDigCh10 = true;
                		  freq10.setVisibility(View.GONE);
                		  inFreqLabel10.setVisibility(View.INVISIBLE);
                		  allDigIn10.setVisibility(View.VISIBLE);
                		  allFreqIn10.setVisibility(View.GONE);
                		  allFreqLabel10.setVisibility(View.INVISIBLE);
                      } else {
                    	  hiLow10.setVisibility(View.GONE);
                    	  isDigCh10 = false;
                		  freq10.setVisibility(View.VISIBLE);
                		  inFreqLabel10.setVisibility(View.VISIBLE);
                		  allDigIn10.setVisibility(View.GONE); 
                		  allFreqIn10.setVisibility(View.VISIBLE);
                		  allFreqLabel10.setVisibility(View.VISIBLE);
                      }
                  }
            });
    		inputsRow11 = (TableRow) v.findViewById(R.id.inputsRow12);
    		if (isOutputCh[11]) {
    			inputsRow11.setVisibility(View.GONE);
    		}
            hiLow11 = (RadioButton)v.findViewById(R.id.hi_low11);
            freq11 = (TextView)v.findViewById(R.id.input_freq11);
            inFreqLabel11 = (TextView)v.findViewById(R.id.infreq_label11);
            rg11 = (RadioGroup) v.findViewById(R.id.radioGroup11);
            if (isDigCh[11]) {
            	hiLow11.setVisibility(View.VISIBLE);
            	freq11.setVisibility(View.GONE);
            	isDigCh11 = true;
            	inFreqLabel11.setVisibility(View.INVISIBLE);
            	rg11.check(R.id.digital11);
            } else {
            	hiLow11.setVisibility(View.GONE);
                freq11.setVisibility(View.VISIBLE);
                isDigCh11 = false;
                inFreqLabel11.setVisibility(View.VISIBLE);
                rg11.check(R.id.count11);
            }
            rg11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.digital11) {
                		  hiLow11.setVisibility(View.VISIBLE);
                		  isDigCh11 = true;
                		  freq11.setVisibility(View.GONE);
                		  inFreqLabel11.setVisibility(View.INVISIBLE);
                		  allDigIn11.setVisibility(View.VISIBLE);
                		  allFreqIn11.setVisibility(View.GONE);
                		  allFreqLabel11.setVisibility(View.INVISIBLE);
                      } else {
                    	  hiLow11.setVisibility(View.GONE);
                    	  isDigCh11 = false;
                		  freq11.setVisibility(View.VISIBLE);
                		  inFreqLabel11.setVisibility(View.VISIBLE);
                		  allDigIn11.setVisibility(View.GONE); 
                		  allFreqIn11.setVisibility(View.VISIBLE);
                		  allFreqLabel11.setVisibility(View.VISIBLE);
                      }
                  }
            });
            inputsRow12 = (TableRow) v.findViewById(R.id.inputsRow13);
            if (isOutputCh[12]) {
    			inputsRow12.setVisibility(View.GONE);
    		}
            hiLow12 = (RadioButton)v.findViewById(R.id.hi_low12);
            freq12 = (TextView)v.findViewById(R.id.input_freq12);
            inFreqLabel12 = (TextView)v.findViewById(R.id.infreq_label12);
            rg12 = (RadioGroup) v.findViewById(R.id.radioGroup12);
            if (isDigCh[12]) {
            	hiLow12.setVisibility(View.VISIBLE);
            	freq12.setVisibility(View.GONE);
            	isDigCh12 = true;
            	inFreqLabel12.setVisibility(View.INVISIBLE);
            	rg12.check(R.id.digital12);
            } else {
            	hiLow12.setVisibility(View.GONE);
                freq12.setVisibility(View.VISIBLE);
                isDigCh12 = false;
                inFreqLabel12.setVisibility(View.VISIBLE);
                rg12.check(R.id.count12);
            }
            rg12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.digital12) {
                		  hiLow12.setVisibility(View.VISIBLE);
                		  isDigCh12 = true;
                		  freq12.setVisibility(View.GONE);
                		  inFreqLabel12.setVisibility(View.INVISIBLE);
                		  allDigIn12.setVisibility(View.VISIBLE);
                		  allFreqIn12.setVisibility(View.GONE);
                		  allFreqLabel12.setVisibility(View.INVISIBLE);
                      } else {
                    	  hiLow12.setVisibility(View.GONE);
                    	  isDigCh12 = false;
                		  freq12.setVisibility(View.VISIBLE);
                		  inFreqLabel12.setVisibility(View.VISIBLE);
                		  allDigIn12.setVisibility(View.GONE); 
                		  allFreqIn12.setVisibility(View.VISIBLE);
                		  allFreqLabel12.setVisibility(View.VISIBLE);
                      }
                  }
            });
    		inputsRow13 = (TableRow) v.findViewById(R.id.inputsRow14);
    		if (isOutputCh[13]) {
    			inputsRow13.setVisibility(View.GONE);
    		}
            hiLow13 = (RadioButton)v.findViewById(R.id.hi_low13);
            freq13 = (TextView)v.findViewById(R.id.input_freq13);
            inFreqLabel13 = (TextView)v.findViewById(R.id.infreq_label13);
            rg13 = (RadioGroup) v.findViewById(R.id.radioGroup13);
            if (isDigCh[13]) {
            	hiLow13.setVisibility(View.VISIBLE);
            	freq13.setVisibility(View.GONE);
            	isDigCh13 = true;
            	inFreqLabel13.setVisibility(View.INVISIBLE);
            	rg13.check(R.id.digital13);
            } else {
            	hiLow13.setVisibility(View.GONE);
                freq13.setVisibility(View.VISIBLE);
                isDigCh13 = false;
                inFreqLabel13.setVisibility(View.VISIBLE);
                rg13.check(R.id.count13);
            }
            rg13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.digital13) {
                		  hiLow13.setVisibility(View.VISIBLE);
                		  isDigCh13 = true;
                		  freq13.setVisibility(View.GONE);
                		  inFreqLabel13.setVisibility(View.INVISIBLE);
                		  allDigIn13.setVisibility(View.VISIBLE);
                		  allFreqIn13.setVisibility(View.GONE);
                		  allFreqLabel13.setVisibility(View.INVISIBLE);
                      } else {
                    	  hiLow13.setVisibility(View.GONE);
                    	  isDigCh13 = false;
                		  freq13.setVisibility(View.VISIBLE);
                		  inFreqLabel13.setVisibility(View.VISIBLE);
                		  allDigIn13.setVisibility(View.GONE); 
                		  allFreqIn13.setVisibility(View.VISIBLE);
                		  allFreqLabel13.setVisibility(View.VISIBLE);
                      }
                  }
            });
    		inputsRow14 = (TableRow) v.findViewById(R.id.inputsRow15);
    		if (isOutputCh[14]) {
    			inputsRow14.setVisibility(View.GONE);
    		}
            hiLow14 = (RadioButton)v.findViewById(R.id.hi_low14);
            freq14 = (TextView)v.findViewById(R.id.input_freq14);
            inFreqLabel14 = (TextView)v.findViewById(R.id.infreq_label14);
            rg14 = (RadioGroup) v.findViewById(R.id.radioGroup14);
            if (isDigCh[14]) {
            	hiLow14.setVisibility(View.VISIBLE);
            	freq14.setVisibility(View.GONE);
            	isDigCh14 = true;
            	inFreqLabel14.setVisibility(View.INVISIBLE);
            	rg14.check(R.id.digital14);
            } else {
            	hiLow14.setVisibility(View.GONE);
                freq14.setVisibility(View.VISIBLE);
                isDigCh14 = false;
                inFreqLabel14.setVisibility(View.VISIBLE);
                rg14.check(R.id.count14);
            }
            rg14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.digital14) {
                		  hiLow14.setVisibility(View.VISIBLE);
                		  isDigCh14 = true;
                		  freq14.setVisibility(View.GONE);
                		  inFreqLabel14.setVisibility(View.INVISIBLE);
                		  allDigIn14.setVisibility(View.VISIBLE);
                		  allFreqIn14.setVisibility(View.GONE);
                		  allFreqLabel14.setVisibility(View.INVISIBLE);
                      } else {
                    	  hiLow14.setVisibility(View.GONE);
                    	  isDigCh14 = false;
                		  freq14.setVisibility(View.VISIBLE);
                		  inFreqLabel14.setVisibility(View.VISIBLE);
                		  allDigIn14.setVisibility(View.GONE); 
                		  allFreqIn14.setVisibility(View.VISIBLE);
                		  allFreqLabel14.setVisibility(View.VISIBLE);
                      }
                  }
            });
    		inputsRow15 = (TableRow) v.findViewById(R.id.inputsRow16);
    		if (isOutputCh[15]) {
    			inputsRow15.setVisibility(View.GONE);
    		}
            hiLow15 = (RadioButton)v.findViewById(R.id.hi_low15);
            freq15 = (TextView)v.findViewById(R.id.input_freq15);
            inFreqLabel15 = (TextView)v.findViewById(R.id.infreq_label15);
            rg15 = (RadioGroup) v.findViewById(R.id.radioGroup15);
            if (isDigCh[15]) {
            	hiLow15.setVisibility(View.VISIBLE);
            	freq15.setVisibility(View.GONE);
            	isDigCh15 = true;
            	inFreqLabel15.setVisibility(View.INVISIBLE);
            	rg15.check(R.id.digital15);
            } else {
            	hiLow15.setVisibility(View.GONE);
                freq15.setVisibility(View.VISIBLE);
                isDigCh15 = false;
                inFreqLabel15.setVisibility(View.VISIBLE);
                rg15.check(R.id.count15);
            }
            rg15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.digital15) {
                		  hiLow15.setVisibility(View.VISIBLE);
                		  isDigCh15 = true;
                		  freq15.setVisibility(View.GONE);
                		  inFreqLabel15.setVisibility(View.INVISIBLE);
                		  allDigIn15.setVisibility(View.VISIBLE);
                		  allFreqIn15.setVisibility(View.GONE);
                		  allFreqLabel15.setVisibility(View.INVISIBLE);
                      } else {
                    	  hiLow15.setVisibility(View.GONE);
                    	  isDigCh15 = false;
                		  freq15.setVisibility(View.VISIBLE);
                		  inFreqLabel15.setVisibility(View.VISIBLE);
                		  allDigIn15.setVisibility(View.GONE); 
                		  allFreqIn15.setVisibility(View.VISIBLE);
                		  allFreqLabel15.setVisibility(View.VISIBLE);
                      }
                  }
            });
           break;
        case 2:
            //resId = R.layout.outputs;
        	resId = R.layout.outputs; //TODO
        	v = inflater.inflate(resId, null, false);   
        	outputsRow0 = (TableRow) v.findViewById(R.id.outputsRow1);
        	outputSV = (ScrollView)v.findViewById(R.id.scrollViewOutputs);
        	outputSV.setScrollbarFadingEnabled(false);
        	outputReset = (Button)v.findViewById(R.id.reset_outputs);
        	outputReset.setVisibility(View.GONE);
        	outputSend = (Button)v.findViewById(R.id.send_outputs);
        	outputSend.setOnTouchListener(new OnTouchListener() {
        	    @Override
        	    // This touch method sees both button down and button up events 
        	    // and sents new settings for both. To disable comment out ACTION UP
        	    public boolean onTouch(View v, MotionEvent event) {
                	int connected = ((AndroiDAQTCPMain)context).btState();
                	if ( connected != 3) {
                        Toast.makeText(context, R.string.not_connected, Toast.LENGTH_SHORT).show();
                        sendOutputs = false;
                    } else {
                    	switch(event.getAction() & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_DOWN:
                        	if (!buttonDown) {
	                        	sendOutputs = true;
	                        	buttonDown = true;
	                        	allFreqOut0.setText(out_freq0.getText()); 
	                			allFreqOut1.setText(out_freq1.getText());  
	                			allFreqOut2.setText(out_freq2.getText());  
	                			allFreqOut3.setText(out_freq3.getText()); 
	                			allFreqOut4.setText(out_freq4.getText());  
	                			allFreqOut5.setText(out_freq5.getText()); 
	                			allFreqOut6.setText(out_freq6.getText());  
	                			allFreqOut7.setText(out_freq7.getText());  
	                			allFreqOut8.setText(out_freq8.getText());  
	                			allFreqOut9.setText(out_freq9.getText());  
	                			allFreqOut10.setText(out_freq10.getText()); 
	                			allFreqOut11.setText(out_freq11.getText());
	                			allFreqOut12.setText(out_freq12.getText());  
	                			allFreqOut13.setText(out_freq13.getText()); 
	                			allFreqOut14.setText(out_freq14.getText()); 
	                			allFreqOut15.setText(out_freq15.getText());
	                			allDutyOut0.setText(duty_freq0.getText()); 
	                			allDutyOut1.setText(duty_freq1.getText());  
	                			allDutyOut2.setText(duty_freq2.getText());  
	                			allDutyOut3.setText(duty_freq3.getText()); 
	                			allDutyOut4.setText(duty_freq4.getText());  
	                			allDutyOut5.setText(duty_freq5.getText()); 
	                			allDutyOut6.setText(duty_freq6.getText());  
	                			allDutyOut7.setText(duty_freq7.getText());  
	                			allDutyOut8.setText(duty_freq8.getText());  
	                			allDutyOut9.setText(duty_freq9.getText());  
	                			allDutyOut10.setText(duty_freq10.getText()); 
	                			allDutyOut11.setText(duty_freq11.getText());
	                			allDutyOut12.setText(duty_freq12.getText());  
	                			allDutyOut13.setText(duty_freq13.getText()); 
	                			allDutyOut14.setText(duty_freq14.getText()); 
	                			allDutyOut15.setText(duty_freq15.getText());
	                        	setProp();
                        	}
                          return true;
                        case MotionEvent.ACTION_UP:
                        	if (buttonDown) {
	                        	sendOutputs = true;
	                        	buttonDown = false;
	                			allFreqOut0.setText("0"); 
	                			allFreqOut1.setText("0");  
	                			allFreqOut2.setText("0");  
	                			allFreqOut3.setText("0"); 
	                			allFreqOut4.setText("0");  
	                			allFreqOut5.setText("0"); 
	                			allFreqOut6.setText("0");  
	                			allFreqOut7.setText("0");  
	                			allFreqOut8.setText("0");  
	                			allFreqOut9.setText("0");  
	                			allFreqOut10.setText("0"); 
	                			allFreqOut11.setText("0"); 
	                			allFreqOut12.setText("0");  
	                			allFreqOut13.setText("0");  
	                			allFreqOut14.setText("0"); 
	                			allFreqOut15.setText("0"); 
	                			allDutyOut0.setText("50"); 
	                			allDutyOut1.setText("50");  
	                			allDutyOut2.setText("50");  
	                			allDutyOut3.setText("50"); 
	                			allDutyOut4.setText("50");  
	                			allDutyOut5.setText("50"); 
	                			allDutyOut6.setText("50");  
	                			allDutyOut7.setText("50");  
	                			allDutyOut8.setText("50");  
	                			allDutyOut9.setText("50");  
	                			allDutyOut10.setText("50"); 
	                			allDutyOut11.setText("50"); 
	                			allDutyOut12.setText("50");  
	                			allDutyOut13.setText("50");  
	                			allDutyOut14.setText("50"); 
	                			allDutyOut15.setText("50"); 
	                        	setProp();
                        	}
                          return true;
                    	}                    	
                    }
					return true;
                }
            });
        	/** Two button methods to have separtate start and stop buttons. 
        	 * To use remove comment out tags below and comment out the above 
        	 * setOnTouchListener method 
        	 **/
        	/*outputSend.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                	int connected = ((AndroiDAQTCPMain)context).btState();
                	if ( connected != 3) {
                        Toast.makeText(context, R.string.not_connected, Toast.LENGTH_SHORT).show();
                        sendOutputs = false;
                    } else {
                    	sendOutputs = true;
                    	allFreqOut0.setText(out_freq0.getText()); 
            			allFreqOut1.setText(out_freq1.getText());  
            			allFreqOut2.setText(out_freq2.getText());  
            			allFreqOut3.setText(out_freq3.getText()); 
            			allFreqOut4.setText(out_freq4.getText());  
            			allFreqOut5.setText(out_freq5.getText()); 
            			allFreqOut6.setText(out_freq6.getText());  
            			allFreqOut7.setText(out_freq7.getText());  
            			allFreqOut8.setText(out_freq8.getText());  
            			allFreqOut9.setText(out_freq9.getText());  
            			allFreqOut10.setText(out_freq10.getText()); 
            			allFreqOut11.setText(out_freq11.getText());
            			allFreqOut12.setText(out_freq12.getText());  
            			allFreqOut13.setText(out_freq13.getText()); 
            			allFreqOut14.setText(out_freq14.getText()); 
            			allFreqOut15.setText(out_freq15.getText());
                    	setProp();
                    }
                }
            });
        	outputReset = (Button)v.findViewById(R.id.reset_outputs);
        	outputReset.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                	int connected = ((AndroiDAQTCPMain)context).btState();
                	if ( connected != 3) {
                        Toast.makeText(context, R.string.not_connected, Toast.LENGTH_SHORT).show();
                        sendOutputs = false;
                    } else {
                    	sendOutputs = true;
            			allFreqOut0.setText("0"); 
            			allFreqOut1.setText("0");  
            			allFreqOut2.setText("0");  
            			allFreqOut3.setText("0"); 
            			allFreqOut4.setText("0");  
            			allFreqOut5.setText("0"); 
            			allFreqOut6.setText("0");  
            			allFreqOut7.setText("0");  
            			allFreqOut8.setText("0");  
            			allFreqOut9.setText("0");  
            			allFreqOut10.setText("0"); 
            			allFreqOut11.setText("0"); 
            			allFreqOut12.setText("0");  
            			allFreqOut13.setText("0");  
            			allFreqOut14.setText("0"); 
            			allFreqOut15.setText("0"); 
                    	setProp();
                    }
                }
            }); */
        	if (!isOutputCh[0]) {
        		outputsRow0.setVisibility(View.GONE);
        	} 
        	out_hiLow0 = (CheckBox)v.findViewById(R.id.out_hi_low0);
        	if (outputState[0]) {
        		out_hiLow0.setChecked(true);
        	}
        	out_hiLow0.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(out_hiLow0.isChecked()) {
                		allDigOut0.setChecked(true);
                    } else {
                    	allDigOut0.setChecked(false);
                    }
                }
            });
        	out_freq0 = (EditText)v.findViewById(R.id.out_freq0);
        	Log.e("Test", "desiredFreq[0] is: " + desiredFreq[0]);
        	out_freq0.setText(desiredFreq[0]);
            outFreqLabel0 = (TextView)v.findViewById(R.id.outfreq_label0);
            duty_freq0 = (EditText)v.findViewById(R.id.out_duty0);
            Log.e("Test", "desiredDuty[0] is: " + desiredDuty[0]);
            duty_freq0.setText(desiredDuty[0]);
            outDutyLabel0 = (TextView)v.findViewById(R.id.outduty_label0);
            rg16 = (RadioGroup) v.findViewById(R.id.radioGroupOut0);
           // Log.e("Test", "isDigCh0 @ output is: " + isDigCh[0]);
        	if (isDigCh[0] ) {
        		out_hiLow0.setVisibility(View.VISIBLE);
        		out_freq0.setVisibility(View.GONE);
        		duty_freq0.setVisibility(View.GONE);
            	isDigCh0 = true;
            	outFreqLabel0.setVisibility(View.INVISIBLE);
            	outDutyLabel0.setVisibility(View.INVISIBLE);
             	rg16.check(R.id.out_digital0);
            } else {
            	out_hiLow0.setVisibility(View.GONE);
            	out_freq0.setVisibility(View.VISIBLE);
            	duty_freq0.setVisibility(View.VISIBLE);
                isDigCh0 = false;
                outFreqLabel0.setVisibility(View.VISIBLE);
                outDutyLabel0.setVisibility(View.VISIBLE);
                rg16.check(R.id.pulse0);
            }
            rg16.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.out_digital0) { // if checked channel is digital
                		  out_hiLow0.setVisibility(View.VISIBLE);
                		  isDigCh0 = true;
                		  out_freq0.setVisibility(View.GONE);
                		  duty_freq0.setVisibility(View.GONE);
                		  outFreqLabel0.setVisibility(View.INVISIBLE);
                		  outDutyLabel0.setVisibility(View.INVISIBLE);
                		  allDigOut0.setVisibility(View.VISIBLE);
                		  allFreqOut0.setVisibility(View.GONE);
                		  allFreqLabel0.setVisibility(View.INVISIBLE);
                		  allDutyOut0.setVisibility(View.GONE);
                		  allDutyLabel0.setVisibility(View.INVISIBLE);
                      } else {
                    	  if (getPulsedOutputs(getOutputChannels()).size() + 1 <= 8 ) {
	                    	  out_hiLow0.setVisibility(View.GONE);
	                    	  isDigCh0 = false;
	                    	  out_freq0.setVisibility(View.VISIBLE);
	                    	  duty_freq0.setVisibility(View.VISIBLE);
	                    	  outFreqLabel0.setVisibility(View.VISIBLE);
	                    	  outDutyLabel0.setVisibility(View.VISIBLE);
	                    	  allDigOut0.setVisibility(View.GONE);
	                		  allFreqOut0.setVisibility(View.VISIBLE);
	                		  allFreqLabel0.setVisibility(View.VISIBLE);
	                		  allDutyOut0.setVisibility(View.VISIBLE);
	                		  allDutyLabel0.setVisibility(View.VISIBLE);
                    	  } else {
                    		  ((AndroiDAQTCPMain)context).showDialog(2);
                    		  rg16.check(R.id.out_digital0);
                    	  }
                      }
                  }
            });
           	out_freq0.setOnKeyListener(new OnKeyListener() {
   				@Override
   				public boolean onKey(View v, int keyCode, KeyEvent event)     {
   					switch (keyCode)	{
   					case KeyEvent.KEYCODE_ENTER:
   						int inputted = out_freq0.getText().toString().length();
   						if (inputted > 0) {
   							getInputString();
   						} else {
   							out_freq0.setText("0");
   							getInputString();
   						}
   						return true;
   					}
   					return false;
   				}
   			});
           	out_freq0.setOnEditorActionListener(new TextView.OnEditorActionListener() {
   				@Override
   				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
   					if (actionId == EditorInfo.IME_ACTION_DONE) {
   						int inputted = out_freq0.getText().toString().length();
   						if (inputted > 0) {
   							getInputString();
   						} else {
   							out_freq0.setText("0");
   							getInputString();
   						}
   						return true;
   					}
   					return false;
   				}
   			});
        	outputsRow1 = (TableRow) v.findViewById(R.id.outputsRow2);
        	if (!isOutputCh[1]) {
        		outputsRow1.setVisibility(View.GONE);
        	}
        	out_hiLow1 = (CheckBox)v.findViewById(R.id.out_hi_low1);
        	if (outputState[1]) {
        		out_hiLow1.setChecked(true);
        	}
        	out_hiLow1.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(out_hiLow1.isChecked()) {
                		allDigOut1.setChecked(true);
                    } else {
                    	allDigOut1.setChecked(false);
                    }
                }
            });
        	out_freq1 = (EditText)v.findViewById(R.id.out_freq1);
        	out_freq1.setText(desiredFreq[1]);
            outFreqLabel1 = (TextView)v.findViewById(R.id.outfreq_label1);
            duty_freq1 = (EditText)v.findViewById(R.id.out_duty1);
            duty_freq1.setText(desiredDuty[1]);
            outDutyLabel1 = (TextView)v.findViewById(R.id.outduty_label1);
            rg17 = (RadioGroup) v.findViewById(R.id.radioGroupOut1);
        	if (isDigCh[1]) {
        		out_hiLow1.setVisibility(View.VISIBLE);
        		out_freq1.setVisibility(View.GONE);
        		duty_freq1.setVisibility(View.GONE);
            	isDigCh1 = true;
            	outFreqLabel1.setVisibility(View.INVISIBLE);
            	outDutyLabel1.setVisibility(View.INVISIBLE);
            	rg17.check(R.id.out_digital1);
            } else {
            	out_hiLow1.setVisibility(View.GONE);
            	out_freq1.setVisibility(View.VISIBLE);
            	duty_freq1.setVisibility(View.VISIBLE);
                isDigCh1 = false;
                outFreqLabel1.setVisibility(View.VISIBLE);
                outDutyLabel1.setVisibility(View.VISIBLE);
                rg17.check(R.id.pulse1);
            }
        	rg17.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.out_digital1) {
                		  out_hiLow1.setVisibility(View.VISIBLE);
                		  isDigCh1 = true;
                		  out_freq1.setVisibility(View.GONE);
                		  duty_freq1.setVisibility(View.GONE);
                		  outFreqLabel1.setVisibility(View.INVISIBLE);
                		  outDutyLabel1.setVisibility(View.INVISIBLE);
                		  allDigOut1.setVisibility(View.VISIBLE);
                		  allFreqOut1.setVisibility(View.GONE);
                		  allFreqLabel1.setVisibility(View.INVISIBLE);
                		  allDutyOut1.setVisibility(View.GONE);
                		  allDutyLabel1.setVisibility(View.INVISIBLE);
                      } else {
                    	  if (getPulsedOutputs(getOutputChannels()).size() + 1 <= 8 ) {
	                    	  out_hiLow1.setVisibility(View.GONE);
	                    	  isDigCh1 = false;
	                    	  out_freq1.setVisibility(View.VISIBLE);
	                    	  duty_freq1.setVisibility(View.VISIBLE);
	                    	  outFreqLabel1.setVisibility(View.VISIBLE);
	                    	  outDutyLabel1.setVisibility(View.VISIBLE);
	                    	  allDigOut1.setVisibility(View.GONE);
	                		  allFreqOut1.setVisibility(View.VISIBLE);
	                		  allFreqLabel1.setVisibility(View.VISIBLE);
	                		  allDutyOut1.setVisibility(View.VISIBLE);
	                		  allDutyLabel1.setVisibility(View.VISIBLE);
                    	  } else {
                    		  ((AndroiDAQTCPMain)context).showDialog(2);
                    		  rg17.check(R.id.out_digital1);
                    	  }
                      }
                  }
            });
            out_freq1.setOnKeyListener(new OnKeyListener() {
   				@Override
   				public boolean onKey(View v, int keyCode, KeyEvent event)     {
   					switch (keyCode)	{
   					case KeyEvent.KEYCODE_ENTER:
   						int inputted = out_freq1.getText().toString().length();
   						if (inputted > 0) {
   							getInputString();
   						} else {
   							out_freq1.setText("0");
   							getInputString();
   						}
   						return true;
   					}
   					return false;
   				}
   			});
           	out_freq1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
   				@Override
   				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
    					if (actionId == EditorInfo.IME_ACTION_DONE) {
    						int inputted = out_freq1.getText().toString().length();
       						if (inputted > 0) {
       							getInputString();
       						} else {
       							out_freq1.setText("0");
       							getInputString();
       						}
   						return true;
   					}
   					return false;
   				}
   			});
        	outputsRow2 = (TableRow) v.findViewById(R.id.outputsRow3);
        	if (!isOutputCh[2]) {
        		outputsRow2.setVisibility(View.GONE);
        	}
        	out_hiLow2 = (CheckBox)v.findViewById(R.id.out_hi_low2);
        	if (outputState[2]) {
        		out_hiLow2.setChecked(true);
        	}
        	out_hiLow2.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(out_hiLow2.isChecked()) {
                		allDigOut2.setChecked(true);
                    } else {
                    	allDigOut2.setChecked(false);
                    }
                }
            });
        	out_freq2 = (EditText)v.findViewById(R.id.out_freq2);
        	out_freq2.setText(desiredFreq[2]);
        	outFreqLabel2 = (TextView)v.findViewById(R.id.outfreq_label2);
        	duty_freq2 = (EditText)v.findViewById(R.id.out_duty2);
        	duty_freq2.setText(desiredDuty[2]);
        	outDutyLabel2 = (TextView)v.findViewById(R.id.outduty_label2);           
            rg18  = (RadioGroup) v.findViewById(R.id.radioGroupOut2);
        	if (isDigCh[2]) {
        		out_hiLow2.setVisibility(View.VISIBLE);
        		out_freq2.setVisibility(View.GONE);
        		duty_freq2.setVisibility(View.GONE);
            	isDigCh2 = true;
            	outFreqLabel2.setVisibility(View.INVISIBLE);
            	outDutyLabel2.setVisibility(View.INVISIBLE);
            	rg18.check(R.id.out_digital2);
            } else {
            	out_hiLow2.setVisibility(View.GONE);
            	out_freq2.setVisibility(View.VISIBLE);
            	duty_freq2.setVisibility(View.VISIBLE);
                isDigCh2 = false;
                outFreqLabel2.setVisibility(View.VISIBLE);
                outDutyLabel2.setVisibility(View.VISIBLE);
                rg18.check(R.id.pulse2);
            }
            rg18.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.out_digital2) {
                		  out_hiLow2.setVisibility(View.VISIBLE);
                		  isDigCh2 = true;
                		  out_freq2.setVisibility(View.GONE);
                		  duty_freq2.setVisibility(View.GONE);
                		  outFreqLabel2.setVisibility(View.INVISIBLE);
                		  outDutyLabel2.setVisibility(View.INVISIBLE);
                		  allDigOut2.setVisibility(View.VISIBLE);
                		  allFreqOut2.setVisibility(View.GONE);
                		  allFreqLabel2.setVisibility(View.INVISIBLE);
                		  allDutyOut2.setVisibility(View.GONE);
                		  allDutyLabel2.setVisibility(View.INVISIBLE);
                      } else {
                    	  if (getPulsedOutputs(getOutputChannels()).size() + 1 <= 8 ) {
	                    	  out_hiLow2.setVisibility(View.GONE);
	                    	  isDigCh2 = false;
	                    	  out_freq2.setVisibility(View.VISIBLE);
	                    	  duty_freq2.setVisibility(View.VISIBLE);
	                    	  outFreqLabel2.setVisibility(View.VISIBLE);
	                    	  outDutyLabel2.setVisibility(View.VISIBLE);
	                    	  allDigOut2.setVisibility(View.GONE);
	                		  allFreqOut2.setVisibility(View.VISIBLE);
	                		  allFreqLabel2.setVisibility(View.VISIBLE);
	                		  allDutyOut2.setVisibility(View.VISIBLE);
	                		  allDutyLabel2.setVisibility(View.VISIBLE);
                    	  } else {
                    		  ((AndroiDAQTCPMain)context).showDialog(2);
                    		  rg18.check(R.id.out_digital2);
                    	  }
                      }
                  }
            });
            out_freq2.setOnKeyListener(new OnKeyListener() {
   				@Override
   				public boolean onKey(View v, int keyCode, KeyEvent event)     {
   					switch (keyCode)	{
   					case KeyEvent.KEYCODE_ENTER:
   						int inputted = out_freq2.getText().toString().length();
   						if (inputted > 0) {
   							getInputString();
   						} else {
   							out_freq2.setText("0");
   							getInputString();
   						}
   						return true;
   					}
   					return false;
   				}
   			});
           	out_freq2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
   				@Override
   				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
    					if (actionId == EditorInfo.IME_ACTION_DONE) {
    						int inputted = out_freq2.getText().toString().length();
       						if (inputted > 0) {
       							getInputString();
       						} else {
       							out_freq2.setText("0");
       							getInputString();
       						}
   						return true;
   					}
   					return false;
   				}
   			});
        	outputsRow3 = (TableRow) v.findViewById(R.id.outputsRow4);
        	if (!isOutputCh[3]) {
        		outputsRow3.setVisibility(View.GONE);
        	}
        	out_hiLow3 = (CheckBox)v.findViewById(R.id.out_hi_low3);
        	if (outputState[3]) {
        		out_hiLow3.setChecked(true);
        	}
        	out_hiLow3.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(out_hiLow3.isChecked()) {
                		allDigOut3.setChecked(true);
                    } else {
                    	allDigOut3.setChecked(false);
                    }
                }
            });
        	out_freq3 = (EditText)v.findViewById(R.id.out_freq3);
        	out_freq3.setText(desiredFreq[3]);
            outFreqLabel3 = (TextView)v.findViewById(R.id.outfreq_label3);
            duty_freq3 = (EditText)v.findViewById(R.id.out_duty3);
        	duty_freq3.setText(desiredDuty[3]);
        	outDutyLabel3 = (TextView)v.findViewById(R.id.outduty_label3); 
            rg19 = (RadioGroup) v.findViewById(R.id.radioGroupOut3);
        	if (isDigCh[3]) {
        		out_hiLow3.setVisibility(View.VISIBLE);
        		out_freq3.setVisibility(View.GONE);
        		duty_freq3.setVisibility(View.GONE);
            	isDigCh3 = true;
            	outFreqLabel3.setVisibility(View.INVISIBLE);
            	outDutyLabel3.setVisibility(View.INVISIBLE);
            	rg19.check(R.id.out_digital3);
            } else {
            	out_hiLow3.setVisibility(View.GONE);
            	out_freq3.setVisibility(View.VISIBLE);
            	duty_freq3.setVisibility(View.VISIBLE);
                isDigCh3 = false;
                outFreqLabel3.setVisibility(View.VISIBLE);
                duty_freq3.setVisibility(View.VISIBLE);
                rg19.check(R.id.pulse3);
            }
            rg19.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.out_digital3) {
                		  out_hiLow3.setVisibility(View.VISIBLE);
                		  isDigCh3 = true;
                		  out_freq3.setVisibility(View.GONE);
                		  duty_freq3.setVisibility(View.GONE);
                		  outFreqLabel3.setVisibility(View.INVISIBLE);
                		  outDutyLabel3.setVisibility(View.INVISIBLE);
                		  allDigOut3.setVisibility(View.VISIBLE);
                		  allFreqOut3.setVisibility(View.GONE);
                		  allFreqLabel3.setVisibility(View.INVISIBLE);
                		  allDutyOut3.setVisibility(View.GONE);
                		  allDutyLabel3.setVisibility(View.INVISIBLE);
                      } else {
                    	  if (getPulsedOutputs(getOutputChannels()).size() + 1 <= 8 ) {
	                    	  out_hiLow3.setVisibility(View.GONE);
	                    	  isDigCh3 = false;
	                    	  out_freq3.setVisibility(View.VISIBLE);
	                    	  duty_freq3.setVisibility(View.VISIBLE);
	                    	  outFreqLabel3.setVisibility(View.VISIBLE);
	                    	  outDutyLabel3.setVisibility(View.VISIBLE);
	                    	  allDigOut3.setVisibility(View.GONE);
	                		  allFreqOut3.setVisibility(View.VISIBLE);
	                		  allFreqLabel3.setVisibility(View.VISIBLE);
	                		  allDutyOut3.setVisibility(View.VISIBLE);
	                		  allDutyLabel3.setVisibility(View.VISIBLE);
                    	  } else {
                    		  ((AndroiDAQTCPMain)context).showDialog(2);
                    		  rg19.check(R.id.out_digital3);
                    	  }
                      }
                  }
            });
            out_freq3.setOnKeyListener(new OnKeyListener() {
   				@Override
   				public boolean onKey(View v, int keyCode, KeyEvent event)     {
   					switch (keyCode)	{
   					case KeyEvent.KEYCODE_ENTER:
   						int inputted = out_freq3.getText().toString().length();
   						if (inputted > 0) {
   							getInputString();
   						} else {
   							out_freq3.setText("0");
   							getInputString();
   						}
   						return true;
   					}
   					return false;
   				}
   			});
           	out_freq3.setOnEditorActionListener(new TextView.OnEditorActionListener() {
   				@Override
   				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
    					if (actionId == EditorInfo.IME_ACTION_DONE) {
    						int inputted = out_freq3.getText().toString().length();
       						if (inputted > 0) {
       							getInputString();
       						} else {
       							out_freq3.setText("0");
       							getInputString();
       						}
   						return true;
   					}
   					return false;
   				}
   			});
        	outputsRow4 = (TableRow) v.findViewById(R.id.outputsRow5);
        	if (!isOutputCh[4]) {
        		outputsRow4.setVisibility(View.GONE);
        	}
        	out_hiLow4 = (CheckBox)v.findViewById(R.id.out_hi_low4);
        	if (outputState[4]) {
        		out_hiLow4.setChecked(true);
        	}
        	out_hiLow4.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(out_hiLow4.isChecked()) {
                		allDigOut4.setChecked(true);
                    } else {
                    	allDigOut4.setChecked(false);
                    }
                }
            });
        	out_freq4 = (EditText)v.findViewById(R.id.out_freq4);
        	out_freq4.setText(desiredFreq[4]);
            outFreqLabel4 = (TextView)v.findViewById(R.id.outfreq_label4);
            duty_freq4 = (EditText)v.findViewById(R.id.out_duty4);
        	duty_freq4.setText(desiredDuty[4]);
        	outDutyLabel4 = (TextView)v.findViewById(R.id.outduty_label4);
            rg20 = (RadioGroup) v.findViewById(R.id.radioGroupOut4);
        	if (isDigCh[4]) {
        		out_hiLow4.setVisibility(View.VISIBLE);
        		out_freq4.setVisibility(View.GONE);
        		duty_freq4.setVisibility(View.GONE);
            	isDigCh4 = true;
            	outFreqLabel4.setVisibility(View.INVISIBLE);
            	outDutyLabel4.setVisibility(View.INVISIBLE);
            	rg20.check(R.id.out_digital4);
            } else {
            	out_hiLow4.setVisibility(View.GONE);
            	out_freq4.setVisibility(View.VISIBLE);
            	duty_freq4.setVisibility(View.VISIBLE);
                isDigCh4 = false;
                outFreqLabel4.setVisibility(View.VISIBLE);
                outDutyLabel4.setVisibility(View.VISIBLE);
                rg20.check(R.id.pulse4);
            }
            rg20.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.out_digital4) {
                		  out_hiLow4.setVisibility(View.VISIBLE);
                		  isDigCh4 = true;
                		  out_freq4.setVisibility(View.GONE);
                		  duty_freq4.setVisibility(View.GONE);
                		  outFreqLabel4.setVisibility(View.INVISIBLE);
                		  outDutyLabel4.setVisibility(View.INVISIBLE);
                		  allDigOut4.setVisibility(View.VISIBLE);
                		  allFreqOut4.setVisibility(View.GONE);
                		  allFreqLabel4.setVisibility(View.INVISIBLE);
                		  allDutyOut4.setVisibility(View.GONE);
                		  allDutyLabel4.setVisibility(View.INVISIBLE);
                      } else {
                    	  if (getPulsedOutputs(getOutputChannels()).size() + 1 <= 8 ) {
	                    	  out_hiLow4.setVisibility(View.GONE);
	                    	  isDigCh4 = false;
	                    	  out_freq4.setVisibility(View.VISIBLE);
	                    	  duty_freq4.setVisibility(View.VISIBLE);
	                    	  outFreqLabel4.setVisibility(View.VISIBLE);
	                    	  outDutyLabel4.setVisibility(View.VISIBLE);
	                    	  allDigOut4.setVisibility(View.GONE);
	                		  allFreqOut4.setVisibility(View.VISIBLE);
	                		  allFreqLabel4.setVisibility(View.VISIBLE);
	                		  allDutyOut4.setVisibility(View.VISIBLE);
	                		  allDutyLabel4.setVisibility(View.VISIBLE);
                    	  } else {
                    		  ((AndroiDAQTCPMain)context).showDialog(2);
                    		  rg20.check(R.id.out_digital4);
                    	  }
                      }
                  }
            });
            out_freq4.setOnKeyListener(new OnKeyListener() {
   				@Override
   				public boolean onKey(View v, int keyCode, KeyEvent event)     {
   					switch (keyCode)	{
   					case KeyEvent.KEYCODE_ENTER:
   						int inputted = out_freq4.getText().toString().length();
   						if (inputted > 0) {
   							getInputString();
   						} else {
   							out_freq4.setText("0");
   							getInputString();
   						}
   						return true;
   					}
   					return false;
   				}
   			});
           	out_freq4.setOnEditorActionListener(new TextView.OnEditorActionListener() {
   				@Override
   				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
    					if (actionId == EditorInfo.IME_ACTION_DONE) {
    						int inputted = out_freq4.getText().toString().length();
       						if (inputted > 0) {
       							getInputString();
       						} else {
       							out_freq4.setText("0");
       							getInputString();
       						}
   						return true;
   					}
   					return false;
   				}
   			});
        	outputsRow5 = (TableRow) v.findViewById(R.id.outputsRow6);
        	if (!isOutputCh[5]) {
        		outputsRow5.setVisibility(View.GONE);
        	}
        	out_hiLow5 = (CheckBox)v.findViewById(R.id.out_hi_low5);
        	if (outputState[5]) {
        		out_hiLow5.setChecked(true);
        	}
        	out_hiLow5.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(out_hiLow5.isChecked()) {
                		allDigOut5.setChecked(true);
                    } else {
                    	allDigOut5.setChecked(false);
                    }
                }
            });
        	out_freq5 = (EditText)v.findViewById(R.id.out_freq5);
        	out_freq5.setText(desiredFreq[5]);
            outFreqLabel5 = (TextView)v.findViewById(R.id.outfreq_label5);
            duty_freq5 = (EditText)v.findViewById(R.id.out_duty5);
        	duty_freq5.setText(desiredDuty[5]);
        	outDutyLabel5 = (TextView)v.findViewById(R.id.outduty_label5);
            rg21  = (RadioGroup) v.findViewById(R.id.radioGroupOut5);
        	if (isDigCh[5]) {
        		out_hiLow5.setVisibility(View.VISIBLE);
        		out_freq5.setVisibility(View.GONE);
        		duty_freq5.setVisibility(View.GONE);
            	isDigCh5 = true;
            	outFreqLabel5.setVisibility(View.INVISIBLE);
            	outDutyLabel5.setVisibility(View.INVISIBLE);
            	rg21.check(R.id.out_digital5);
            } else {
            	out_hiLow5.setVisibility(View.GONE);
            	out_freq5.setVisibility(View.VISIBLE);
            	duty_freq5.setVisibility(View.VISIBLE);
                isDigCh5 = false;
                outFreqLabel5.setVisibility(View.VISIBLE);
                outDutyLabel5.setVisibility(View.VISIBLE);
                rg21.check(R.id.pulse5);
            }
            rg21.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.out_digital5) {
                		  out_hiLow5.setVisibility(View.VISIBLE);
                		  isDigCh5 = true;
                		  out_freq5.setVisibility(View.GONE);
                		  duty_freq5.setVisibility(View.GONE);
                		  outFreqLabel5.setVisibility(View.INVISIBLE);
                		  outDutyLabel5.setVisibility(View.INVISIBLE);
                		  allDigOut5.setVisibility(View.VISIBLE);
                		  allFreqOut5.setVisibility(View.GONE);
                		  allFreqLabel5.setVisibility(View.INVISIBLE);
                		  allDutyOut5.setVisibility(View.GONE);
                		  allDutyLabel5.setVisibility(View.INVISIBLE);
                      } else {
                    	  if (getPulsedOutputs(getOutputChannels()).size() + 1 <= 8 ) {
	                    	  out_hiLow5.setVisibility(View.GONE);
	                    	  isDigCh5 = false;
	                    	  out_freq5.setVisibility(View.VISIBLE);
	                    	  duty_freq5.setVisibility(View.VISIBLE);
	                    	  outFreqLabel5.setVisibility(View.VISIBLE);
	                    	  outDutyLabel5.setVisibility(View.VISIBLE);
	                    	  allDigOut5.setVisibility(View.GONE);
	                		  allFreqOut5.setVisibility(View.VISIBLE);
	                		  allFreqLabel5.setVisibility(View.VISIBLE);
	                		  allDutyOut5.setVisibility(View.VISIBLE);
	                		  allDutyLabel5.setVisibility(View.VISIBLE);
                    	  } else {
                    		  ((AndroiDAQTCPMain)context).showDialog(2);
                    		  rg21.check(R.id.out_digital5);
                    	  }
                      }
                  }
            });
            out_freq5.setOnKeyListener(new OnKeyListener() {
   				@Override
   				public boolean onKey(View v, int keyCode, KeyEvent event)     {
   					switch (keyCode)	{
   					case KeyEvent.KEYCODE_ENTER:
   						int inputted = out_freq5.getText().toString().length();
   						if (inputted > 0) {
   							getInputString();
   						} else {
   							out_freq5.setText("0");
   							getInputString();
   						}
   						return true;
   					}
   					return false;
   				}
   			});
           	out_freq5.setOnEditorActionListener(new TextView.OnEditorActionListener() {
   				@Override
   				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
    					if (actionId == EditorInfo.IME_ACTION_DONE) {
    						int inputted = out_freq5.getText().toString().length();
       						if (inputted > 0) {
       							getInputString();
       						} else {
       							out_freq5.setText("0");
       							getInputString();
       						}
   						return true;
   					}
   					return false;
   				}
   			});
        	outputsRow6 = (TableRow) v.findViewById(R.id.outputsRow7);
        	if (!isOutputCh[6]) {
        		outputsRow6.setVisibility(View.GONE);
        	}
        	out_hiLow6 = (CheckBox)v.findViewById(R.id.out_hi_low6);
        	if (outputState[6]) {
        		out_hiLow6.setChecked(true);
        	}
        	out_hiLow6.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(out_hiLow6.isChecked()) {
                		allDigOut6.setChecked(true);
                    } else {
                    	allDigOut6.setChecked(false);
                    }
                }
            });
        	out_freq6 = (EditText)v.findViewById(R.id.out_freq6);
        	out_freq6.setText(desiredFreq[6]);
            outFreqLabel6 = (TextView)v.findViewById(R.id.outfreq_label6);
            duty_freq6 = (EditText)v.findViewById(R.id.out_duty6);
        	duty_freq6.setText(desiredDuty[6]);
        	outDutyLabel6 = (TextView)v.findViewById(R.id.outduty_label6);
            rg22 = (RadioGroup) v.findViewById(R.id.radioGroupOut6);
        	if (isDigCh[6]) {
        		out_hiLow6.setVisibility(View.VISIBLE);
        		out_freq6.setVisibility(View.GONE);
        		duty_freq6.setVisibility(View.GONE);
            	isDigCh6 = true;
            	outFreqLabel6.setVisibility(View.INVISIBLE);
            	outDutyLabel6.setVisibility(View.INVISIBLE);
            	rg22.check(R.id.out_digital6);
            } else {
            	out_hiLow6.setVisibility(View.GONE);
            	out_freq6.setVisibility(View.VISIBLE);
            	duty_freq6.setVisibility(View.VISIBLE);
                isDigCh6 = false;
                outFreqLabel6.setVisibility(View.VISIBLE);
                outDutyLabel6.setVisibility(View.VISIBLE);
                rg22.check(R.id.pulse6);
            }
            rg22.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.out_digital6) {
                		  out_hiLow6.setVisibility(View.VISIBLE);
                		  isDigCh6 = true;
                		  out_freq6.setVisibility(View.GONE);
                		  duty_freq6.setVisibility(View.GONE);
                		  outFreqLabel6.setVisibility(View.INVISIBLE);
                		  outDutyLabel6.setVisibility(View.INVISIBLE);
                		  allDigOut6.setVisibility(View.VISIBLE);
                		  allFreqOut6.setVisibility(View.GONE);
                		  allFreqLabel6.setVisibility(View.INVISIBLE);
                		  allDutyOut6.setVisibility(View.GONE);
                		  allDutyLabel6.setVisibility(View.INVISIBLE);
                      } else {
                    	  if (getPulsedOutputs(getOutputChannels()).size() + 1 <= 8 ) {
	                    	  out_hiLow6.setVisibility(View.GONE);
	                    	  isDigCh6 = false;
	                    	  out_freq6.setVisibility(View.VISIBLE);
	                    	  duty_freq6.setVisibility(View.VISIBLE);
	                    	  outFreqLabel6.setVisibility(View.VISIBLE);
	                    	  outDutyLabel6.setVisibility(View.VISIBLE);
	                    	  allDigOut6.setVisibility(View.GONE);
	                		  allFreqOut6.setVisibility(View.VISIBLE);
	                		  allFreqLabel6.setVisibility(View.VISIBLE);
	                		  allDutyOut6.setVisibility(View.VISIBLE);
	                		  allDutyLabel6.setVisibility(View.VISIBLE);
                    	  } else {
                    		  ((AndroiDAQTCPMain)context).showDialog(2);
                    		  rg22.check(R.id.out_digital6);
                    	  }
                      }
                  }
            });
            out_freq6.setOnKeyListener(new OnKeyListener() {
   				@Override
   				public boolean onKey(View v, int keyCode, KeyEvent event)     {
   					switch (keyCode)	{
   					case KeyEvent.KEYCODE_ENTER:
   						int inputted = out_freq6.getText().toString().length();
   						if (inputted > 0) {
   							getInputString();
   						} else {
   							out_freq6.setText("0");
   							getInputString();
   						}
   						return true;
   					}
   					return false;
   				}
   			});
           	out_freq6.setOnEditorActionListener(new TextView.OnEditorActionListener() {
   				@Override
   				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
    					if (actionId == EditorInfo.IME_ACTION_DONE) {
    						int inputted = out_freq6.getText().toString().length();
       						if (inputted > 0) {
       							getInputString();
       						} else {
       							out_freq6.setText("0");
       							getInputString();
       						}
   						return true;
   					}
   					return false;
   				}
   			});
        	outputsRow7 = (TableRow) v.findViewById(R.id.outputsRow8);
        	if (!isOutputCh[7]) {
        		outputsRow7.setVisibility(View.GONE);
        	}
        	out_hiLow7 = (CheckBox)v.findViewById(R.id.out_hi_low7);
        	if (outputState[7]) {
        		out_hiLow7.setChecked(true);
        	}
        	out_hiLow7.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(out_hiLow7.isChecked()) {
                		allDigOut7.setChecked(true);
                    } else {
                    	allDigOut7.setChecked(false);
                    }
                }
            });
        	out_freq7 = (EditText)v.findViewById(R.id.out_freq7);
        	out_freq7.setText(desiredFreq[7]);
            outFreqLabel7 = (TextView)v.findViewById(R.id.outfreq_label7);
            duty_freq7 = (EditText)v.findViewById(R.id.out_duty7);
        	duty_freq7.setText(desiredDuty[7]);
        	outDutyLabel7 = (TextView)v.findViewById(R.id.outduty_label7);
            rg23  = (RadioGroup) v.findViewById(R.id.radioGroupOut7);
        	if (isDigCh[7]) {
        		out_hiLow7.setVisibility(View.VISIBLE);
        		out_freq7.setVisibility(View.GONE);
        		duty_freq7.setVisibility(View.GONE);
            	isDigCh7 = true;
            	outFreqLabel7.setVisibility(View.INVISIBLE);
            	outDutyLabel7.setVisibility(View.INVISIBLE);
            	rg23.check(R.id.out_digital7);
            } else {
            	out_hiLow7.setVisibility(View.GONE);
            	out_freq7.setVisibility(View.VISIBLE);
            	duty_freq7.setVisibility(View.VISIBLE);
                isDigCh7 = false;
                outFreqLabel7.setVisibility(View.VISIBLE);
                outDutyLabel7.setVisibility(View.VISIBLE);
                rg23.check(R.id.pulse7);
            }
            rg23.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.out_digital7) {
                		  out_hiLow7.setVisibility(View.VISIBLE);
                		  isDigCh7 = true;
                		  out_freq7.setVisibility(View.GONE);
                		  duty_freq7.setVisibility(View.GONE);
                		  outFreqLabel7.setVisibility(View.INVISIBLE);
                		  outDutyLabel7.setVisibility(View.INVISIBLE);
                		  allDigOut7.setVisibility(View.VISIBLE);
                		  allFreqOut7.setVisibility(View.GONE);
                		  allFreqLabel7.setVisibility(View.INVISIBLE);
                		  allDutyOut7.setVisibility(View.GONE);
                		  allDutyLabel7.setVisibility(View.INVISIBLE);
                      } else {
                    	  if (getPulsedOutputs(getOutputChannels()).size() + 1 <= 8 ) {
	                    	  out_hiLow7.setVisibility(View.GONE);
	                    	  isDigCh7 = false;
	                    	  out_freq7.setVisibility(View.VISIBLE);
	                    	  duty_freq7.setVisibility(View.VISIBLE);
	                    	  outFreqLabel7.setVisibility(View.VISIBLE);
	                    	  outDutyLabel7.setVisibility(View.VISIBLE);
	                    	  allDigOut7.setVisibility(View.GONE);
	                		  allFreqOut7.setVisibility(View.VISIBLE);
	                		  allFreqLabel7.setVisibility(View.VISIBLE);
	                		  allDutyOut7.setVisibility(View.VISIBLE);
	                		  allDutyLabel7.setVisibility(View.VISIBLE);
                    	  } else {
                    		  ((AndroiDAQTCPMain)context).showDialog(2);
                    		  rg23.check(R.id.out_digital7);
                    	  }
                      }
                  }
            });
            out_freq7.setOnKeyListener(new OnKeyListener() {
   				@Override
   				public boolean onKey(View v, int keyCode, KeyEvent event)     {
   					switch (keyCode)	{
   					case KeyEvent.KEYCODE_ENTER:
   						int inputted = out_freq7.getText().toString().length();
   						if (inputted > 0) {
   							getInputString();
   						} else {
   							out_freq7.setText("0");
   							getInputString();
   						}
   						return true;
   					}
   					return false;
   				}
   			});
           	out_freq7.setOnEditorActionListener(new TextView.OnEditorActionListener() {
   				@Override
   				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
    					if (actionId == EditorInfo.IME_ACTION_DONE) {
    						int inputted = out_freq7.getText().toString().length();
       						if (inputted > 0) {
       							getInputString();
       						} else {
       							out_freq7.setText("0");
       							getInputString();
       						}
   						return true;
   					}
   					return false;
   				}
   			});
        	outputsRow8 = (TableRow) v.findViewById(R.id.outputsRow9);
        	if (!isOutputCh[8]) {
        		outputsRow8.setVisibility(View.GONE);
        	}
        	out_hiLow8 = (CheckBox)v.findViewById(R.id.out_hi_low8);
        	if (outputState[8]) {
        		out_hiLow8.setChecked(true);
        	}
        	out_hiLow8.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(out_hiLow8.isChecked()) {
                		allDigOut8.setChecked(true);
                    } else {
                    	allDigOut8.setChecked(false);
                    }
                }
            });
        	out_freq8 = (EditText)v.findViewById(R.id.out_freq8);
        	out_freq8.setText(desiredFreq[8]);
            outFreqLabel8 = (TextView)v.findViewById(R.id.outfreq_label8);
            duty_freq8 = (EditText)v.findViewById(R.id.out_duty8);
        	duty_freq8.setText(desiredDuty[8]);
        	outDutyLabel8 = (TextView)v.findViewById(R.id.outduty_label8);
            rg24 = (RadioGroup) v.findViewById(R.id.radioGroupOut8);
        	if (isDigCh[8]) {
        		out_hiLow8.setVisibility(View.VISIBLE);
        		out_freq8.setVisibility(View.GONE);
        		duty_freq8.setVisibility(View.GONE);
            	isDigCh8 = true;
            	outFreqLabel8.setVisibility(View.INVISIBLE);
            	outDutyLabel8.setVisibility(View.INVISIBLE);
            	rg24.check(R.id.out_digital8);
            } else {
            	out_hiLow8.setVisibility(View.GONE);
            	out_freq8.setVisibility(View.VISIBLE);
            	duty_freq8.setVisibility(View.VISIBLE);
                isDigCh8 = false;
                outFreqLabel8.setVisibility(View.VISIBLE);
                outDutyLabel8.setVisibility(View.VISIBLE);
                rg24.check(R.id.pulse8);
            }
            rg24.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.out_digital8) {
                		  out_hiLow8.setVisibility(View.VISIBLE);
                		  isDigCh8 = true;
                		  out_freq8.setVisibility(View.GONE);
                		  duty_freq8.setVisibility(View.GONE);
                		  outFreqLabel8.setVisibility(View.INVISIBLE);
                		  outDutyLabel8.setVisibility(View.INVISIBLE);
                		  allDigOut8.setVisibility(View.VISIBLE);
                		  allFreqOut8.setVisibility(View.GONE);
                		  allFreqLabel8.setVisibility(View.INVISIBLE);
                		  allDutyOut8.setVisibility(View.GONE);
                		  allDutyLabel8.setVisibility(View.INVISIBLE);
                      } else {
                    	  if (getPulsedOutputs(getOutputChannels()).size() + 1 <= 8 ) {
	                    	  out_hiLow8.setVisibility(View.GONE);
	                    	  isDigCh8 = false;
	                    	  out_freq8.setVisibility(View.VISIBLE);
	                    	  duty_freq8.setVisibility(View.VISIBLE);
	                    	  outFreqLabel8.setVisibility(View.VISIBLE);
	                    	  outDutyLabel8.setVisibility(View.VISIBLE);
	                    	  allDigOut8.setVisibility(View.GONE);
	                		  allFreqOut8.setVisibility(View.VISIBLE);
	                		  allFreqLabel8.setVisibility(View.VISIBLE);
	                		  allDutyOut8.setVisibility(View.VISIBLE);
	                		  allDutyLabel8.setVisibility(View.VISIBLE);
                    	  } else {
                    		  ((AndroiDAQTCPMain)context).showDialog(2);
                    		  rg24.check(R.id.out_digital8);
                    	  }
                      }
                  }
            });
            out_freq8.setOnKeyListener(new OnKeyListener() {
   				@Override
   				public boolean onKey(View v, int keyCode, KeyEvent event)     {
   					switch (keyCode)	{
   					case KeyEvent.KEYCODE_ENTER:
   						int inputted = out_freq8.getText().toString().length();
   						if (inputted > 0) {
   							getInputString();
   						} else {
   							out_freq8.setText("0");
   							getInputString();
   						}
   						return true;
   					}
   					return false;
   				}
   			});
           	out_freq8.setOnEditorActionListener(new TextView.OnEditorActionListener() {
   				@Override
   				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
    					if (actionId == EditorInfo.IME_ACTION_DONE) {
    						int inputted = out_freq8.getText().toString().length();
       						if (inputted > 0) {
       							getInputString();
       						} else {
       							out_freq8.setText("0");
       							getInputString();
       						}
   						return true;
   					}
   					return false;
   				}
   			});
        	outputsRow9 = (TableRow) v.findViewById(R.id.outputsRow10);
        	if (!isOutputCh[9]) {
        		outputsRow9.setVisibility(View.GONE);
        	}
        	out_hiLow9 = (CheckBox)v.findViewById(R.id.out_hi_low9);
        	if (outputState[9]) {
        		out_hiLow9.setChecked(true);
        	}
        	out_hiLow9.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(out_hiLow9.isChecked()) {
                		allDigOut9.setChecked(true);
                    } else {
                    	allDigOut9.setChecked(false);
                    }
                }
            });
        	out_freq9 = (EditText)v.findViewById(R.id.out_freq9);
        	out_freq9.setText(desiredFreq[9]);
            outFreqLabel9 = (TextView)v.findViewById(R.id.outfreq_label9);
            duty_freq9 = (EditText)v.findViewById(R.id.out_duty9);
        	duty_freq9.setText(desiredDuty[9]);
        	outDutyLabel9 = (TextView)v.findViewById(R.id.outduty_label9);
            rg25 = (RadioGroup) v.findViewById(R.id.radioGroupOut9);
        	if (isDigCh[9]) {
        		out_hiLow9.setVisibility(View.VISIBLE);
        		out_freq9.setVisibility(View.GONE);
        		duty_freq9.setVisibility(View.GONE);
            	isDigCh9 = true;
            	outFreqLabel9.setVisibility(View.INVISIBLE);
            	outDutyLabel9.setVisibility(View.INVISIBLE);
            	rg25.check(R.id.out_digital9);
            } else {
            	out_hiLow9.setVisibility(View.GONE);
            	out_freq9.setVisibility(View.VISIBLE);
            	duty_freq9.setVisibility(View.VISIBLE);
                isDigCh9 = false;
                outFreqLabel9.setVisibility(View.VISIBLE);
                outDutyLabel9.setVisibility(View.VISIBLE);
                rg25.check(R.id.pulse9);
            }
            rg25.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.out_digital9) {
                		  out_hiLow9.setVisibility(View.VISIBLE);
                		  isDigCh9 = true;
                		  out_freq9.setVisibility(View.GONE);
                		  duty_freq9.setVisibility(View.GONE);
                		  outFreqLabel9.setVisibility(View.INVISIBLE);
                		  outDutyLabel9.setVisibility(View.INVISIBLE);
                		  allDigOut9.setVisibility(View.VISIBLE);
                		  allFreqOut9.setVisibility(View.GONE);
                		  allFreqLabel9.setVisibility(View.INVISIBLE);
                		  allDutyOut9.setVisibility(View.GONE);
                		  allDutyLabel9.setVisibility(View.INVISIBLE);
                      } else {
                    	  if (getPulsedOutputs(getOutputChannels()).size() + 1 <= 8 ) {
	                    	  out_hiLow9.setVisibility(View.GONE);
	                    	  isDigCh9 = false;
	                    	  out_freq9.setVisibility(View.VISIBLE);
	                    	  duty_freq9.setVisibility(View.VISIBLE);
	                    	  outFreqLabel9.setVisibility(View.VISIBLE);
	                    	  outDutyLabel9.setVisibility(View.VISIBLE);
	                    	  allDigOut9.setVisibility(View.GONE);
	                		  allFreqOut9.setVisibility(View.VISIBLE);
	                		  allFreqLabel9.setVisibility(View.VISIBLE);
	                		  allDutyOut9.setVisibility(View.VISIBLE);
	                		  allDutyLabel9.setVisibility(View.VISIBLE);
                    	  } else {
                    		  ((AndroiDAQTCPMain)context).showDialog(2);
                    		  rg25.check(R.id.out_digital9);
                    	  }
                      }
                  }
            });
            out_freq9.setOnKeyListener(new OnKeyListener() {
   				@Override
   				public boolean onKey(View v, int keyCode, KeyEvent event)     {
   					switch (keyCode)	{
   					case KeyEvent.KEYCODE_ENTER:
   						int inputted = out_freq9.getText().toString().length();
   						if (inputted > 0) {
   							getInputString();
   						} else {
   							out_freq9.setText("0");
   							getInputString();
   						}
   						return true;
   					}
   					return false;
   				}
   			});
           	out_freq9.setOnEditorActionListener(new TextView.OnEditorActionListener() {
   				@Override
   				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
    					if (actionId == EditorInfo.IME_ACTION_DONE) {
    						int inputted = out_freq9.getText().toString().length();
       						if (inputted > 0) {
       							getInputString();
       						} else {
       							out_freq9.setText("0");
       							getInputString();
       						}
   						return true;
   					}
   					return false;
   				}
   			});
        	outputsRow10 = (TableRow) v.findViewById(R.id.outputsRow11);
        	if (!isOutputCh[10]) {
        		outputsRow10.setVisibility(View.GONE);
        	}
        	out_hiLow10 = (CheckBox)v.findViewById(R.id.out_hi_low10);
        	if (outputState[10]) {
        		out_hiLow10.setChecked(true);
        	}
        	out_hiLow10.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(out_hiLow10.isChecked()) {
                		allDigOut10.setChecked(true);
                    } else {
                    	allDigOut10.setChecked(false);
                    }
                }
            });
        	out_freq10 = (EditText)v.findViewById(R.id.out_freq10);
        	out_freq10.setText(desiredFreq[10]);
            outFreqLabel10 = (TextView)v.findViewById(R.id.outfreq_label10);
            duty_freq10 = (EditText)v.findViewById(R.id.out_duty10);
        	duty_freq10.setText(desiredDuty[10]);
        	outDutyLabel10 = (TextView)v.findViewById(R.id.outduty_label10);
            rg26 = (RadioGroup) v.findViewById(R.id.radioGroupOut10);
        	if (isDigCh[10]) {
        		out_hiLow10.setVisibility(View.VISIBLE);
        		out_freq10.setVisibility(View.GONE);
        		duty_freq10.setVisibility(View.GONE);
            	isDigCh10 = true;
            	outFreqLabel10.setVisibility(View.INVISIBLE);
            	outDutyLabel10.setVisibility(View.INVISIBLE);
            	rg26.check(R.id.out_digital10);
            } else {
            	out_hiLow10.setVisibility(View.GONE);
            	out_freq10.setVisibility(View.VISIBLE);
            	duty_freq10.setVisibility(View.VISIBLE);
                isDigCh10 = false;
                outFreqLabel10.setVisibility(View.VISIBLE);
                outDutyLabel10.setVisibility(View.VISIBLE);
                rg26.check(R.id.pulse10);
            }
            rg26.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.out_digital10) {
                		  out_hiLow10.setVisibility(View.VISIBLE);
                		  isDigCh10 = true;
                		  out_freq10.setVisibility(View.GONE);
                		  duty_freq10.setVisibility(View.GONE);
                		  outFreqLabel10.setVisibility(View.INVISIBLE);
                		  outDutyLabel10.setVisibility(View.INVISIBLE);
                		  allDigOut10.setVisibility(View.VISIBLE);
                		  allFreqOut10.setVisibility(View.GONE);
                		  allFreqLabel10.setVisibility(View.INVISIBLE);
                		  allDutyOut10.setVisibility(View.GONE);
                		  allDutyLabel10.setVisibility(View.INVISIBLE);
                      } else {
                    	  if (getPulsedOutputs(getOutputChannels()).size() + 1 <= 8 ) {
	                    	  out_hiLow10.setVisibility(View.GONE);
	                    	  isDigCh10 = false;
	                    	  out_freq10.setVisibility(View.VISIBLE);
	                    	  duty_freq10.setVisibility(View.VISIBLE);
	                    	  outFreqLabel10.setVisibility(View.VISIBLE);
	                    	  outDutyLabel10.setVisibility(View.VISIBLE);
	                    	  allDigOut10.setVisibility(View.GONE);
	                		  allFreqOut10.setVisibility(View.VISIBLE);
	                		  allFreqLabel10.setVisibility(View.VISIBLE);
	                		  allDutyOut10.setVisibility(View.VISIBLE);
	                		  allDutyLabel10.setVisibility(View.VISIBLE);
                    	  } else {
                    		  ((AndroiDAQTCPMain)context).showDialog(2);
                    		  rg26.check(R.id.out_digital10);
                    	  }
                      }
                  }
            });
            out_freq10.setOnKeyListener(new OnKeyListener() {
   				@Override
   				public boolean onKey(View v, int keyCode, KeyEvent event)     {
   					switch (keyCode)	{
   					case KeyEvent.KEYCODE_ENTER:
   						int inputted = out_freq10.getText().toString().length();
   						if (inputted > 0) {
   							getInputString();
   						} else {
   							out_freq10.setText("0");
   							getInputString();
   						}
   						return true;
   					}
   					return false;
   				}
   			});
           	out_freq10.setOnEditorActionListener(new TextView.OnEditorActionListener() {
   				@Override
   				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
    					if (actionId == EditorInfo.IME_ACTION_DONE) {
    						int inputted = out_freq10.getText().toString().length();
       						if (inputted > 0) {
       							getInputString();
       						} else {
       							out_freq10.setText("0");
       							getInputString();
       						}
   						return true;
   					}
   					return false;
   				}
   			});
        	outputsRow11 = (TableRow) v.findViewById(R.id.outputsRow12);
        	if (!isOutputCh[11]) {
        		outputsRow11.setVisibility(View.GONE);
        	}
        	out_hiLow11 = (CheckBox)v.findViewById(R.id.out_hi_low11);
        	if (outputState[11]) {
        		out_hiLow11.setChecked(true);
        	}
        	out_hiLow11.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(out_hiLow11.isChecked()) {
                		allDigOut11.setChecked(true);
                    } else {
                    	allDigOut11.setChecked(false);
                    }
                }
            });
        	out_freq11 = (EditText)v.findViewById(R.id.out_freq11);
        	out_freq11.setText(desiredFreq[11]);
            outFreqLabel11 = (TextView)v.findViewById(R.id.outfreq_label11);
            duty_freq11 = (EditText)v.findViewById(R.id.out_duty11);
        	duty_freq11.setText(desiredDuty[11]);
        	outDutyLabel11 = (TextView)v.findViewById(R.id.outduty_label11);
            rg27 = (RadioGroup) v.findViewById(R.id.radioGroupOut11);
        	if (isDigCh[11]) {
        		out_hiLow11.setVisibility(View.VISIBLE);
        		out_freq11.setVisibility(View.GONE);
        		duty_freq11.setVisibility(View.GONE);
            	isDigCh11 = true;
            	outFreqLabel11.setVisibility(View.INVISIBLE);
            	outDutyLabel11.setVisibility(View.INVISIBLE);
            	rg27.check(R.id.out_digital11);
            } else {
            	out_hiLow11.setVisibility(View.GONE);
            	out_freq11.setVisibility(View.VISIBLE);
            	duty_freq11.setVisibility(View.VISIBLE);
                isDigCh11 = false;
                outFreqLabel11.setVisibility(View.VISIBLE);
                outDutyLabel11.setVisibility(View.VISIBLE);
                rg27.check(R.id.pulse11);
            }
            rg27.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.out_digital11) {
                		  out_hiLow11.setVisibility(View.VISIBLE);
                		  isDigCh11 = true;
                		  out_freq11.setVisibility(View.GONE);
                		  duty_freq11.setVisibility(View.GONE);
                		  outFreqLabel11.setVisibility(View.INVISIBLE);
                		  outDutyLabel11.setVisibility(View.INVISIBLE);
                		  allDigOut11.setVisibility(View.VISIBLE);
                		  allFreqOut11.setVisibility(View.GONE);
                		  allFreqLabel11.setVisibility(View.INVISIBLE);
                		  allDutyOut11.setVisibility(View.GONE);
                		  allDutyLabel11.setVisibility(View.INVISIBLE);
                      } else {
                    	  if (getPulsedOutputs(getOutputChannels()).size() + 1 <= 8 ) {
	                    	  out_hiLow11.setVisibility(View.GONE);
	                    	  isDigCh11 = false;
	                    	  out_freq11.setVisibility(View.VISIBLE);
	                    	  duty_freq11.setVisibility(View.VISIBLE);
	                    	  outFreqLabel11.setVisibility(View.VISIBLE);
	                    	  outDutyLabel11.setVisibility(View.VISIBLE);
	                    	  allDigOut11.setVisibility(View.GONE);
	                		  allFreqOut11.setVisibility(View.VISIBLE);
	                		  allFreqLabel11.setVisibility(View.VISIBLE);
	                		  allDutyOut11.setVisibility(View.VISIBLE);
	                		  allDutyLabel11.setVisibility(View.VISIBLE);
                    	  }  else {
                    		  ((AndroiDAQTCPMain)context).showDialog(2);
                    		  rg27.check(R.id.out_digital11);
                    	  }
                      }
                  }
            });
            out_freq11.setOnKeyListener(new OnKeyListener() {
   				@Override
   				public boolean onKey(View v, int keyCode, KeyEvent event)     {
   					switch (keyCode)	{
   					case KeyEvent.KEYCODE_ENTER:
   						int inputted = out_freq11.getText().toString().length();
   						if (inputted > 0) {
   							getInputString();
   						} else {
   							out_freq11.setText("0");
   							getInputString();
   						}
   						return true;
   					}
   					return false;
   				}
   			});
           	out_freq11.setOnEditorActionListener(new TextView.OnEditorActionListener() {
   				@Override
   				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
    					if (actionId == EditorInfo.IME_ACTION_DONE) {
    						int inputted = out_freq11.getText().toString().length();
       						if (inputted > 0) {
       							getInputString();
       						} else {
       							out_freq11.setText("0");
       							getInputString();
       						}
   						return true;
   					}
   					return false;
   				}
   			});
        	outputsRow12 = (TableRow) v.findViewById(R.id.outputsRow13);
        	if (!isOutputCh[12]) {
        		outputsRow12.setVisibility(View.GONE);
        	}
        	out_hiLow12 = (CheckBox)v.findViewById(R.id.out_hi_low12);
        	if (outputState[12]) {
        		out_hiLow12.setChecked(true);
        	}
        	out_hiLow12.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(out_hiLow12.isChecked()) {
                		allDigOut12.setChecked(true);
                    } else {
                    	allDigOut12.setChecked(false);
                    }
                }
            });
        	out_freq12 = (EditText)v.findViewById(R.id.out_freq12);
        	out_freq12.setText(desiredFreq[12]);
            outFreqLabel12 = (TextView)v.findViewById(R.id.outfreq_label12);
            duty_freq12 = (EditText)v.findViewById(R.id.out_duty12);
        	duty_freq12.setText(desiredDuty[12]);
        	outDutyLabel12 = (TextView)v.findViewById(R.id.outduty_label12);
            rg28 = (RadioGroup) v.findViewById(R.id.radioGroupOut12);
        	if (isDigCh[12]) {
        		out_hiLow12.setVisibility(View.VISIBLE);
        		out_freq12.setVisibility(View.GONE);
        		duty_freq12.setVisibility(View.GONE);
            	isDigCh12 = true;
            	outFreqLabel12.setVisibility(View.INVISIBLE);
            	outDutyLabel12.setVisibility(View.INVISIBLE);
            	rg28.check(R.id.out_digital12);
            } else {
            	out_hiLow12.setVisibility(View.GONE);
            	out_freq12.setVisibility(View.VISIBLE);
            	duty_freq12.setVisibility(View.VISIBLE);
                isDigCh12 = false;
                outFreqLabel12.setVisibility(View.VISIBLE);
                outDutyLabel12.setVisibility(View.VISIBLE);
                rg28.check(R.id.pulse12);
            }
            rg28.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.out_digital12) {
                		  out_hiLow12.setVisibility(View.VISIBLE);
                		  isDigCh12 = true;
                		  out_freq12.setVisibility(View.GONE);
                		  duty_freq12.setVisibility(View.GONE);
                		  outFreqLabel12.setVisibility(View.INVISIBLE);
                		  outDutyLabel12.setVisibility(View.INVISIBLE);
                		  allDigOut12.setVisibility(View.VISIBLE);
                		  allFreqOut12.setVisibility(View.GONE);
                		  allFreqLabel12.setVisibility(View.INVISIBLE);
                		  allDutyOut12.setVisibility(View.GONE);
                		  allDutyLabel12.setVisibility(View.INVISIBLE);
                      } else {
                    	  if (getPulsedOutputs(getOutputChannels()).size() + 1 <= 8 ) {
	                    	  out_hiLow12.setVisibility(View.GONE);
	                    	  isDigCh12 = false;
	                    	  out_freq12.setVisibility(View.VISIBLE);
	                    	  duty_freq12.setVisibility(View.VISIBLE);
	                    	  outFreqLabel12.setVisibility(View.VISIBLE);
	                    	  outDutyLabel12.setVisibility(View.VISIBLE);
	                    	  allDigOut12.setVisibility(View.GONE);
	                		  allFreqOut12.setVisibility(View.VISIBLE);
	                		  allFreqLabel12.setVisibility(View.VISIBLE);
	                		  allDutyOut12.setVisibility(View.VISIBLE);
	                		  allDutyLabel12.setVisibility(View.VISIBLE);
                    	  } else {
                    		  ((AndroiDAQTCPMain)context).showDialog(2);
                    		  rg28.check(R.id.out_digital12);
                    	  }
                      }
                  }
            });
            out_freq12.setOnKeyListener(new OnKeyListener() {
   				@Override
   				public boolean onKey(View v, int keyCode, KeyEvent event)     {
   					switch (keyCode)	{
   					case KeyEvent.KEYCODE_ENTER:
   						int inputted = out_freq12.getText().toString().length();
   						if (inputted > 0) {
   							getInputString();
   						} else {
   							out_freq12.setText("0");
   							getInputString();
   						}
   						return true;
   					}
   					return false;
   				}
   			});
           	out_freq12.setOnEditorActionListener(new TextView.OnEditorActionListener() {
   				@Override
   				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
    					if (actionId == EditorInfo.IME_ACTION_DONE) {
    						int inputted = out_freq12.getText().toString().length();
       						if (inputted > 0) {
       							getInputString();
       						} else {
       							out_freq12.setText("0");
       							getInputString();
       						}
   						return true;
   					}
   					return false;
   				}
   			});
        	outputsRow13 = (TableRow) v.findViewById(R.id.outputsRow14);
        	if (!isOutputCh[13]) {
        		outputsRow13.setVisibility(View.GONE);
        	}
        	out_hiLow13 = (CheckBox)v.findViewById(R.id.out_hi_low13);
        	if (outputState[13]) {
        		out_hiLow13.setChecked(true);
        	}
        	out_hiLow13.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(out_hiLow13.isChecked()) {
                		allDigOut13.setChecked(true);
                    } else {
                    	allDigOut13.setChecked(false);
                    }
                }
            });
        	out_freq13 = (EditText)v.findViewById(R.id.out_freq13);
        	out_freq13.setText(desiredFreq[13]);
            outFreqLabel13 = (TextView)v.findViewById(R.id.outfreq_label13);
            duty_freq13 = (EditText)v.findViewById(R.id.out_duty13);
        	duty_freq13.setText(desiredDuty[13]);
        	outDutyLabel13 = (TextView)v.findViewById(R.id.outduty_label13);
            rg29 = (RadioGroup) v.findViewById(R.id.radioGroupOut13);
        	if (isDigCh[13]) {
        		out_hiLow13.setVisibility(View.VISIBLE);
        		out_freq13.setVisibility(View.GONE);
        		duty_freq13.setVisibility(View.GONE);
            	isDigCh13 = true;
            	outFreqLabel13.setVisibility(View.INVISIBLE);
            	outDutyLabel13.setVisibility(View.INVISIBLE);
            	rg29.check(R.id.out_digital13);
            } else {
            	out_hiLow13.setVisibility(View.GONE);
            	out_freq13.setVisibility(View.VISIBLE);
            	duty_freq13.setVisibility(View.VISIBLE);
                isDigCh13 = false;
                outFreqLabel13.setVisibility(View.VISIBLE);
                outDutyLabel13.setVisibility(View.VISIBLE);
                rg29.check(R.id.pulse13);
            }
            rg29.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.out_digital13) {
                		  out_hiLow13.setVisibility(View.VISIBLE);
                		  isDigCh13 = true;
                		  out_freq13.setVisibility(View.GONE);
                		  duty_freq13.setVisibility(View.GONE);
                		  outFreqLabel13.setVisibility(View.INVISIBLE);
                		  outDutyLabel13.setVisibility(View.INVISIBLE);
                		  allDigOut13.setVisibility(View.VISIBLE);
                		  allFreqOut13.setVisibility(View.GONE);
                		  allFreqLabel13.setVisibility(View.INVISIBLE);
                		  allDutyOut13.setVisibility(View.GONE);
                		  allDutyLabel13.setVisibility(View.INVISIBLE);
                      } else {
                    	  if (getPulsedOutputs(getOutputChannels()).size() + 1 <= 8 ) {
	                    	  out_hiLow13.setVisibility(View.GONE);
	                    	  isDigCh13 = false;
	                    	  out_freq13.setVisibility(View.VISIBLE);
	                    	  duty_freq13.setVisibility(View.VISIBLE);
	                    	  outFreqLabel13.setVisibility(View.VISIBLE);
	                    	  outDutyLabel13.setVisibility(View.VISIBLE);
	                    	  allDigOut13.setVisibility(View.GONE);
	                		  allFreqOut13.setVisibility(View.VISIBLE);
	                		  allFreqLabel13.setVisibility(View.VISIBLE);
	                		  allDutyOut13.setVisibility(View.VISIBLE);
	                		  allDutyLabel13.setVisibility(View.VISIBLE);
                    	  } else {
                    		  ((AndroiDAQTCPMain)context).showDialog(2);
                    		  rg29.check(R.id.out_digital13);
                    	  }
                      }
                  }
            });
            out_freq13.setOnKeyListener(new OnKeyListener() {
   				@Override
   				public boolean onKey(View v, int keyCode, KeyEvent event)     {
   					switch (keyCode)	{
   					case KeyEvent.KEYCODE_ENTER:
   						int inputted = out_freq13.getText().toString().length();
   						if (inputted > 0) {
   							getInputString();
   						} else {
   							out_freq13.setText("0");
   							getInputString();
   						}
   						return true;
   					}
   					return false;
   				}
   			});
           	out_freq13.setOnEditorActionListener(new TextView.OnEditorActionListener() {
   				@Override
   				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
    					if (actionId == EditorInfo.IME_ACTION_DONE) {
    						int inputted = out_freq13.getText().toString().length();
       						if (inputted > 0) {
       							getInputString();
       						} else {
       							out_freq13.setText("0");
       							getInputString();
       						}
   						return true;
   					}
   					return false;
   				}
   			});
        	outputsRow14 = (TableRow) v.findViewById(R.id.outputsRow15);
        	if (!isOutputCh[14]) {
        		outputsRow14.setVisibility(View.GONE);
        	}
        	out_hiLow14 = (CheckBox)v.findViewById(R.id.out_hi_low14);
        	if (outputState[14]) {
        		out_hiLow14.setChecked(true);
        	}
        	out_hiLow14.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(out_hiLow14.isChecked()) {
                		allDigOut14.setChecked(true);
                    } else {
                    	allDigOut14.setChecked(false);
                    }
                }
            });
        	out_freq14 = (EditText)v.findViewById(R.id.out_freq14);
        	out_freq14.setText(desiredFreq[14]);
            outFreqLabel14 = (TextView)v.findViewById(R.id.outfreq_label14);
            duty_freq14 = (EditText)v.findViewById(R.id.out_duty14);
        	duty_freq14.setText(desiredDuty[14]);
        	outDutyLabel14 = (TextView)v.findViewById(R.id.outduty_label14);
            rg30 = (RadioGroup) v.findViewById(R.id.radioGroupOut14);
        	if (isDigCh[14]) {
        		out_hiLow14.setVisibility(View.VISIBLE);
        		out_freq14.setVisibility(View.GONE);
        		duty_freq14.setVisibility(View.GONE);
            	isDigCh14 = true;
            	outFreqLabel14.setVisibility(View.INVISIBLE);
            	outDutyLabel14.setVisibility(View.INVISIBLE);
            	rg30.check(R.id.out_digital14);
            } else {
            	out_hiLow14.setVisibility(View.GONE);
            	out_freq14.setVisibility(View.VISIBLE);
            	duty_freq14.setVisibility(View.VISIBLE);
                isDigCh14 = false;
                outFreqLabel14.setVisibility(View.VISIBLE);
                outDutyLabel14.setVisibility(View.VISIBLE);
                rg30.check(R.id.pulse14);
            }
            rg30.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.out_digital14) {
                		  out_hiLow14.setVisibility(View.VISIBLE);
                		  isDigCh14 = true;
                		  out_freq14.setVisibility(View.GONE);
                		  duty_freq14.setVisibility(View.GONE);
                		  outFreqLabel14.setVisibility(View.INVISIBLE);
                		  outDutyLabel14.setVisibility(View.INVISIBLE);
                		  allDigOut14.setVisibility(View.VISIBLE);
                		  allFreqOut14.setVisibility(View.GONE);
                		  allFreqLabel14.setVisibility(View.INVISIBLE);
                		  allDutyOut14.setVisibility(View.GONE);
                		  allDutyLabel14.setVisibility(View.INVISIBLE);
                      } else {
                    	  //Log.e("Test", "Number of pulsed inputs: " + getPulsedOutputs(getOutputChannels()).size());
                    	  if (getPulsedOutputs(getOutputChannels()).size() + 1 <= 8 ) {
	                    	  out_hiLow14.setVisibility(View.GONE);
	                    	  isDigCh14 = false;
	                    	  out_freq14.setVisibility(View.VISIBLE);
	                    	  duty_freq14.setVisibility(View.VISIBLE);
	                    	  outFreqLabel14.setVisibility(View.VISIBLE);
	                    	  outDutyLabel14.setVisibility(View.VISIBLE);
	                    	  allDigOut14.setVisibility(View.GONE);
	                		  allFreqOut14.setVisibility(View.VISIBLE);
	                		  allFreqLabel14.setVisibility(View.VISIBLE);
	                		  allDutyOut14.setVisibility(View.VISIBLE);
	                		  allDutyLabel14.setVisibility(View.VISIBLE);
                    	  } else {
                    		  ((AndroiDAQTCPMain)context).showDialog(2);
                    		  rg30.check(R.id.out_digital14);
                    	  }
                      }
                  }
            });
            out_freq14.setOnKeyListener(new OnKeyListener() {
   				@Override
   				public boolean onKey(View v, int keyCode, KeyEvent event)     {
   					switch (keyCode)	{
   					case KeyEvent.KEYCODE_ENTER:
   						int inputted = out_freq14.getText().toString().length();
   						if (inputted > 0) {
   							getInputString();
   						} else {
   							out_freq14.setText("0");
   							getInputString();
   						}
   						return true;
   					}
   					return false;
   				}
   			});
           	out_freq14.setOnEditorActionListener(new TextView.OnEditorActionListener() {
   				@Override
   				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
    					if (actionId == EditorInfo.IME_ACTION_DONE) {
    						int inputted = out_freq14.getText().toString().length();
       						if (inputted > 0) {
       							getInputString();
       						} else {
       							out_freq14.setText("0");
       							getInputString();
       						}
   						return true;
   					}
   					return false;
   				}
   			});
        	outputsRow15 = (TableRow) v.findViewById(R.id.outputsRow16);
        	if (!isOutputCh[15]) {
        		outputsRow15.setVisibility(View.GONE);
        	}
        	out_hiLow15 = (CheckBox)v.findViewById(R.id.out_hi_low15);
        	if (outputState[15]) {
        		out_hiLow15.setChecked(true);
        	}
        	out_hiLow15.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(out_hiLow15.isChecked()) {
                		allDigOut15.setChecked(true);
                    } else {
                    	allDigOut15.setChecked(false);
                    }
                }
            });
        	out_freq15 = (EditText)v.findViewById(R.id.out_freq15);
        	out_freq15.setText(desiredFreq[15]);
            outFreqLabel15 = (TextView)v.findViewById(R.id.outfreq_label15);
            duty_freq15 = (EditText)v.findViewById(R.id.out_duty15);
        	duty_freq15.setText(desiredDuty[15]);
        	outDutyLabel15 = (TextView)v.findViewById(R.id.outduty_label15);
            rg31 = (RadioGroup) v.findViewById(R.id.radioGroupOut15);
        	if (isDigCh[15]) {
        		out_hiLow15.setVisibility(View.VISIBLE);
        		out_freq15.setVisibility(View.GONE);
        		duty_freq15.setVisibility(View.GONE);
            	isDigCh15 = true;
            	outFreqLabel15.setVisibility(View.INVISIBLE);
            	outDutyLabel15.setVisibility(View.INVISIBLE);
            	rg31.check(R.id.out_digital15);
            } else {
            	out_hiLow15.setVisibility(View.GONE);
            	out_freq15.setVisibility(View.VISIBLE);
            	duty_freq15.setVisibility(View.VISIBLE);
                isDigCh15 = false;
                outFreqLabel15.setVisibility(View.VISIBLE);
                outDutyLabel15.setVisibility(View.VISIBLE);
                rg31.check(R.id.pulse15);
            }
            rg31.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  public void onCheckedChanged (RadioGroup group, int checkedId) {
                	  if (checkedId == R.id.out_digital15) {
                		  out_hiLow15.setVisibility(View.VISIBLE);
                		  isDigCh15 = true;
                		  out_freq15.setVisibility(View.GONE);
                		  duty_freq15.setVisibility(View.GONE);
                		  outFreqLabel15.setVisibility(View.INVISIBLE);
                		  outDutyLabel15.setVisibility(View.INVISIBLE);
                		  allDigOut15.setVisibility(View.VISIBLE);
                		  allFreqOut15.setVisibility(View.GONE);
                		  allFreqLabel15.setVisibility(View.INVISIBLE);
                		  allDutyOut15.setVisibility(View.GONE);
                		  allDutyLabel15.setVisibility(View.INVISIBLE);
                      } else {
                    	  if (getPulsedOutputs(getOutputChannels()).size() + 1 <= 8 ) {
	                    	  out_hiLow15.setVisibility(View.GONE);
	                    	  isDigCh15 = false;
	                    	  out_freq15.setVisibility(View.VISIBLE);
	                    	  duty_freq15.setVisibility(View.VISIBLE);
	                    	  outFreqLabel15.setVisibility(View.VISIBLE);
	                    	  outDutyLabel15.setVisibility(View.VISIBLE);
	                    	  allDigOut15.setVisibility(View.GONE);
	                    	  allFreqOut15.setVisibility(View.VISIBLE);
	                    	  allFreqLabel15.setVisibility(View.VISIBLE);
	                    	  allDutyOut15.setVisibility(View.VISIBLE);
	                    	  allDutyLabel15.setVisibility(View.VISIBLE);
                    	  } else {
                    		  ((AndroiDAQTCPMain)context).showDialog(2);
                    		  rg31.check(R.id.out_digital15);
                    	  }
                      }
                  }
            });
            out_freq15.setOnKeyListener(new OnKeyListener() {
   				@Override
   				public boolean onKey(View v, int keyCode, KeyEvent event)     {
   					switch (keyCode)	{
   					case KeyEvent.KEYCODE_ENTER:
   						int inputted = out_freq15.getText().toString().length();
   						if (inputted > 0) {
   							getInputString();
   						} else {
   							out_freq15.setText("0");
   							getInputString();
   						}
   						return true;
   					}
   					return false;
   				}
   			});
           	out_freq15.setOnEditorActionListener(new TextView.OnEditorActionListener() {
   				@Override
   				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
    					if (actionId == EditorInfo.IME_ACTION_DONE) {
    						int inputted = out_freq15.getText().toString().length();
       						if (inputted > 0) {
       							getInputString();
       						} else {
       							out_freq15.setText("0");
       							getInputString();
       						}
   						return true;
   					}
   					return false;
   				}
   			});
            break;
        case 3:
            resId = R.layout.voltages;
            v = inflater.inflate(resId, null, false);  
            readVolts = (Button)v.findViewById(R.id.read_volts);
            voltsSV = (ScrollView)v.findViewById(R.id.scrollViewVolts);
            voltsSV.setScrollbarFadingEnabled(false);
            readVolts.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                	//((AndroiDAQTCPMain) context).getVolts(true);
                	int connected = ((AndroiDAQTCPMain)context).btState();
                	if ( connected != 3) {
                        Toast.makeText(context, R.string.not_connected, Toast.LENGTH_SHORT).show();
                        runVolts = false;
                    } else {
                    	runVolts = true;
                    	setProp();
                    }
                }
            });
            readContVolts = (Button)v.findViewById(R.id.read_cont_volts);
            readContVolts.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                	//((AndroiDAQTCPMain) context).getVolts(true);
                	int connected = ((AndroiDAQTCPMain)context).btState();
                	if ( connected != 3) {
                        Toast.makeText(context, R.string.not_connected, Toast.LENGTH_SHORT).show();
                        runContVolts = false;
                	} else {
                    	if (!runContVolts) {
                    		readContVolts.setText("Stop Cont. Read Volts from AndroiDAQ");
                        	runContVolts = true;
                        	((AndroiDAQTCPMain) context).getVoltsCont(true);
                    	} else {
                    		readContVolts.setText("Continuous Read Volts from AndroiDAQ");
                    		runContVolts = false;
                    		((AndroiDAQTCPMain) context).stopContVolts();
                    	}
                    }
                }
            });
            voltagesRow0 = (TableRow) v.findViewById(R.id.voltagesRow1);
            voltagesRow0.setVisibility(View.VISIBLE);
            volts1 = (TextView)v.findViewById(R.id.voltageReading1);
            voltagesRow1 = (TableRow) v.findViewById(R.id.voltagesRow2);
            voltagesRow1.setVisibility(View.VISIBLE);
            volts2 = (TextView)v.findViewById(R.id.voltageReading2);
            voltagesRow2 = (TableRow) v.findViewById(R.id.voltagesRow3);
            voltagesRow2.setVisibility(View.VISIBLE);
            volts3 = (TextView)v.findViewById(R.id.voltageReading3);
            voltagesRow3 = (TableRow) v.findViewById(R.id.voltagesRow4);
            voltagesRow3.setVisibility(View.VISIBLE);
            volts4 = (TextView)v.findViewById(R.id.voltageReading4);
            voltagesRow4 = (TableRow) v.findViewById(R.id.voltagesRow5);
            voltagesRow4.setVisibility(View.VISIBLE);
            volts5 = (TextView)v.findViewById(R.id.voltageReading5);
            voltagesRow5 = (TableRow) v.findViewById(R.id.voltagesRow6);
            voltagesRow5.setVisibility(View.VISIBLE);
            volts6 = (TextView)v.findViewById(R.id.voltageReading6);
            voltagesRow6 = (TableRow) v.findViewById(R.id.voltagesRow7);
            voltagesRow6.setVisibility(View.VISIBLE);
            volts7 = (TextView)v.findViewById(R.id.voltageReading7);
            voltagesRow7 = (TableRow) v.findViewById(R.id.voltagesRow8);
            voltagesRow7.setVisibility(View.VISIBLE);
            volts8 = (TextView)v.findViewById(R.id.voltageReading8);
            break;
        case 4: //TODO
            resId = R.layout.all;
            v = inflater.inflate(resId, null, false); 
            setRun = (Button)v.findViewById(R.id.set_and_run);
            allSV = (ScrollView)v.findViewById(R.id.scrollViewAll);
            allSV.setScrollbarFadingEnabled(false);
            setRun.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                	int connected = ((AndroiDAQTCPMain)context).btState();
                	if ( connected != 3) {
                        Toast.makeText(context, R.string.not_connected, Toast.LENGTH_SHORT).show();
                        runAll = false;
                    } else {
                    	runAll = true;
                    	setProp();
                    }  
                }
            });
            allDigIn0 = (RadioButton)v.findViewById(R.id.all_hi_low0);
            allFreqIn0 = (TextView)v.findViewById(R.id.all_input_freq0);
            allDigOut0 = (CheckBox)v.findViewById(R.id.all_out_hi_low0);
            if (outputState[0]) {
            	allDigOut0.setChecked(true);
        	}
            allDigOut0.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                	if(allDigOut0.isChecked()) {
                		out_hiLow0.setChecked(true);
                    } else {
                    	out_hiLow0.setChecked(false);
                    }
                }
            });
            allFreqOut0 = (EditText)v.findViewById(R.id.all_out_freq0);
            allFreqOut0.setText(desiredFreq[0]);
            allFreqLabel0 = (TextView)v.findViewById(R.id.all_freq_label0);
            allDutyOut0 = (EditText)v.findViewById(R.id.all_out_duty0);
            allDutyOut0.setText(desiredDuty[0]);
            allDutyLabel0 = (TextView)v.findViewById(R.id.all_outduty_label0);
            if (isOutputCh[0]) { // if channel is output
            	allDigIn0.setVisibility(View.GONE); //don't display input widgets
            	allFreqIn0.setVisibility(View.GONE);
            	
            	if (isDigCh0) { // if channel is digital
            		allDigOut0.setVisibility(View.VISIBLE); //display digital widget
            		allFreqOut0.setVisibility(View.GONE);
                    allFreqLabel0.setVisibility(View.INVISIBLE);
                    allDutyOut0.setVisibility(View.GONE);
                    allDutyLabel0.setVisibility(View.INVISIBLE);
            	} else { // if channel is count
            		allFreqOut0.setVisibility(View.VISIBLE); //display count widget
            		allDutyOut0.setVisibility(View.VISIBLE);
            		allDigOut0.setVisibility(View.GONE);
                    allFreqLabel0.setVisibility(View.VISIBLE);
                    allDutyLabel0.setVisibility(View.VISIBLE);
            	}
            } else { // if channel is input
            	allDigOut0.setVisibility(View.GONE); //don't display output widgets
            	allFreqOut0.setVisibility(View.GONE);
            	allDutyOut0.setVisibility(View.GONE);
            	if(isDigCh0) { // if channel is digital 
            		allDigIn0.setVisibility(View.VISIBLE); //display digital out widget
            		allFreqIn0.setVisibility(View.GONE);
                    allFreqLabel0.setVisibility(View.INVISIBLE);
                    allDutyOut0.setVisibility(View.GONE);
                    allDutyLabel0.setVisibility(View.INVISIBLE);
            	} else { // if channel is pulse
            		allFreqIn0.setVisibility(View.VISIBLE); // display pulse widget
            		allDigIn0.setVisibility(View.GONE);
                    allFreqLabel0.setVisibility(View.VISIBLE);
            	}
            }
            allFreqOut0.setOnKeyListener(new OnKeyListener() {
   				@Override
   				public boolean onKey(View v, int keyCode, KeyEvent event)     {
   					switch (keyCode)	{
   					case KeyEvent.KEYCODE_ENTER:
   						int inputted = allFreqOut0.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut0.setText("0");
   							getAllInputString();
   						}
   						return true;
   					}
   					return false;
   				}
   			});
            allFreqOut0.setOnEditorActionListener(new TextView.OnEditorActionListener() {
   				@Override
   				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
    					if (actionId == EditorInfo.IME_ACTION_DONE) {
    						int inputted = allFreqOut0.getText().toString().length();
       						if (inputted > 0) {
       							getAllInputString();
       						} else {
       							allFreqOut0.setText("0");
       							getAllInputString();
       						}	
   						return true;
   					}
   					return false;
   				}
   			});
           allDigIn1 = (RadioButton)v.findViewById(R.id.all_hi_low1);
           allFreqIn1 = (TextView)v.findViewById(R.id.all_input_freq1);
           allDigOut1 = (CheckBox)v.findViewById(R.id.all_out_hi_low1);
           if (outputState[1]) {
           	allDigOut1.setChecked(true);
           }
           allDigOut1.setOnClickListener(new OnClickListener() {

               @Override
               public void onClick(View v) {
               	if(allDigOut1.isChecked()) {
               		out_hiLow1.setChecked(true);
                   } else {
                   	out_hiLow1.setChecked(false);
                   }
               }
           });
           allFreqOut1 = (EditText)v.findViewById(R.id.all_out_freq1);
           allFreqOut1.setText(desiredFreq[1]);
           allFreqLabel1 = (TextView)v.findViewById(R.id.all_freq_label1);
           allDutyOut1 = (EditText)v.findViewById(R.id.all_out_duty1);
           allDutyOut1.setText(desiredDuty[1]);
           allDutyLabel1 = (TextView)v.findViewById(R.id.all_outduty_label1);
	       if (isOutputCh[1]) { // if channel is output
	    	   allDigIn1.setVisibility(View.GONE); //don't display input widgets
	    	   allFreqIn1.setVisibility(View.GONE);
	    	   if(isDigCh1) { // if channel is digital
	    		   allDigOut1.setVisibility(View.VISIBLE); //display digital widget
	    		   allFreqOut1.setVisibility(View.GONE);
	    		   allFreqLabel1.setVisibility(View.INVISIBLE);
	    		   allDutyOut1.setVisibility(View.GONE);
	    		   allDutyLabel1.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is count
	    		   allFreqOut1.setVisibility(View.VISIBLE); //display count widget
	    		   allDutyOut1.setVisibility(View.VISIBLE);
	    		   allDigOut1.setVisibility(View.GONE);
	    		   allFreqLabel1.setVisibility(View.VISIBLE);
	    		   allDutyLabel1.setVisibility(View.VISIBLE);
	    	   }
	       } else { // if channel is input
	    	   allDigOut1.setVisibility(View.GONE); //don't display output widgets
	    	   allFreqOut1.setVisibility(View.GONE);
	    	   allDutyOut1.setVisibility(View.GONE);
	    	   if(isDigCh1) { // if channel is digital 
	    		   allDigIn1.setVisibility(View.VISIBLE); //display digital out widget
	    		   allFreqIn1.setVisibility(View.GONE);
	    		   allFreqLabel1.setVisibility(View.INVISIBLE);
	    		   allDutyOut1.setVisibility(View.GONE);
	    		   allDutyLabel1.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is pulse
	    		   allFreqIn1.setVisibility(View.VISIBLE); // display pulse widget
	    		   allDigIn1.setVisibility(View.GONE);
	    		   allFreqLabel1.setVisibility(View.VISIBLE);
	    	   }
            }
	       allFreqOut1.setOnKeyListener(new OnKeyListener() {
  				@Override
  				public boolean onKey(View v, int keyCode, KeyEvent event)     {
  					switch (keyCode)	{
  					case KeyEvent.KEYCODE_ENTER:
  						int inputted = allFreqOut1.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut1.setText("0");
   							getAllInputString();
   						}
  						return true;
  					}
  					return false;
  				}
  			});
           allFreqOut1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
  				@Override
  				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
   					if (actionId == EditorInfo.IME_ACTION_DONE) {
   						int inputted = allFreqOut1.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut1.setText("0");
   							getAllInputString();
   						}
  						return true;
  					}
  					return false;
  				}
  			});
	       allDigIn2 = (RadioButton)v.findViewById(R.id.all_hi_low2);
           allFreqIn2 = (TextView)v.findViewById(R.id.all_input_freq2);
           allDigOut2 = (CheckBox)v.findViewById(R.id.all_out_hi_low2);
           if (outputState[2]) {
           	allDigOut2.setChecked(true);
           }
           allDigOut2.setOnClickListener(new OnClickListener() {

               @Override
               public void onClick(View v) {
               	if(allDigOut2.isChecked()) {
               		out_hiLow2.setChecked(true);
                   } else {
                   	out_hiLow2.setChecked(false);
                   }
               }
           });
           allFreqOut2 = (EditText)v.findViewById(R.id.all_out_freq2);
           allFreqOut2.setText(desiredFreq[2]);
           allFreqLabel2 = (TextView)v.findViewById(R.id.all_freq_label2);
           allDutyOut2 = (EditText)v.findViewById(R.id.all_out_duty2);
           allDutyOut2.setText(desiredDuty[2]);
           allDutyLabel2 = (TextView)v.findViewById(R.id.all_outduty_label2);
	       if (isOutputCh[2]) { // if channel is output
	    	   allDigIn2.setVisibility(View.GONE); //don't display input widgets
	    	   allFreqIn2.setVisibility(View.GONE);
	    	   if(isDigCh2) { // if channel is digital
	    		   allDigOut2.setVisibility(View.VISIBLE); //display digital widget
	    		   allFreqOut2.setVisibility(View.GONE);
	               allFreqLabel2.setVisibility(View.INVISIBLE);
	               allDutyOut2.setVisibility(View.GONE);
	               allDutyLabel2.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is count
	    		   allFreqOut2.setVisibility(View.VISIBLE); //display count widget
	    		   allDutyOut2.setVisibility(View.VISIBLE);
	    		   allDigOut2.setVisibility(View.GONE);
	               allFreqLabel2.setVisibility(View.VISIBLE);
	               allDutyLabel2.setVisibility(View.VISIBLE);
	    	   }
	       } else { // if channel is input
	    	   allDigOut2.setVisibility(View.GONE); //don't display output widgets
	    	   allFreqOut2.setVisibility(View.GONE);
	    	   allDutyOut2.setVisibility(View.GONE);
	    	   if(isDigCh2) { // if channel is digital 
	    		   allDigIn2.setVisibility(View.VISIBLE); //display digital out widget
	    		   allFreqIn2.setVisibility(View.GONE);
	               allFreqLabel2.setVisibility(View.INVISIBLE);
	               allDutyOut2.setVisibility(View.GONE);
	               allDutyLabel2.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is pulse
	    		   allFreqIn2.setVisibility(View.VISIBLE); // display pulse widget
	    		   allDigIn2.setVisibility(View.GONE);
	               allFreqLabel2.setVisibility(View.VISIBLE);
	    	   }
            }
	       allFreqOut2.setOnKeyListener(new OnKeyListener() {
  				@Override
  				public boolean onKey(View v, int keyCode, KeyEvent event)     {
  					switch (keyCode)	{
  					case KeyEvent.KEYCODE_ENTER:
  						int inputted = allFreqOut2.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut2.setText("0");
   							getAllInputString();
   						}
  						return true;
  					}
  					return false;
  				}
  			});
           allFreqOut2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
  				@Override
  				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
   					if (actionId == EditorInfo.IME_ACTION_DONE) {
   						int inputted = allFreqOut2.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut2.setText("0");
   							getAllInputString();
   						}
  						return true;
  					}
  					return false;
  				}
  			});
	       allDigIn3 = (RadioButton)v.findViewById(R.id.all_hi_low3);
           allFreqIn3 = (TextView)v.findViewById(R.id.all_input_freq3);
           allDigOut3 = (CheckBox)v.findViewById(R.id.all_out_hi_low3);
           if (outputState[3]) {
              	allDigOut3.setChecked(true);
           }
           allDigOut3.setOnClickListener(new OnClickListener() {

               @Override
               public void onClick(View v) {
               	if(allDigOut3.isChecked()) {
               		out_hiLow3.setChecked(true);
                   } else {
                   	out_hiLow3.setChecked(false);
                   }
               }
           });
           allFreqOut3 = (EditText)v.findViewById(R.id.all_out_freq3);
           allFreqOut3.setText(desiredFreq[3]);
           allFreqLabel3 = (TextView)v.findViewById(R.id.all_freq_label3);
           allDutyOut3 = (EditText)v.findViewById(R.id.all_out_duty3);
           allDutyOut3.setText(desiredDuty[3]);
           allDutyLabel3 = (TextView)v.findViewById(R.id.all_outduty_label3);
	       if (isOutputCh[3]) { // if channel is output
	    	   allDigIn3.setVisibility(View.GONE); //don't display input widgets
	    	   allFreqIn3.setVisibility(View.GONE);
	    	   if(isDigCh3) { // if channel is digital
	    		   allDigOut3.setVisibility(View.VISIBLE); //display digital widget
	    		   allFreqOut3.setVisibility(View.GONE);
	               allFreqLabel3.setVisibility(View.INVISIBLE);
	               allDutyOut3.setVisibility(View.GONE);
	               allDutyLabel3.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is count
	    		   allFreqOut3.setVisibility(View.VISIBLE); //display count widget
	    		   allDutyOut3.setVisibility(View.VISIBLE);
	    		   allDigOut3.setVisibility(View.GONE);
	               allFreqLabel3.setVisibility(View.VISIBLE);
	               allDutyLabel3.setVisibility(View.VISIBLE);
	    	   }
	       } else { // if channel is input
	    	   allDigOut3.setVisibility(View.GONE); //don't display output widgets
	    	   allFreqOut3.setVisibility(View.GONE);
	    	   allDutyOut3.setVisibility(View.GONE);
	    	   if(isDigCh3) { // if channel is digital 
	    		   allDigIn3.setVisibility(View.VISIBLE); //display digital out widget
	    		   allFreqIn3.setVisibility(View.GONE);
	               allFreqLabel3.setVisibility(View.INVISIBLE);
	               allDutyOut3.setVisibility(View.GONE);
	               allDutyLabel3.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is pulse
	    		   allFreqIn3.setVisibility(View.VISIBLE); // display pulse widget
	    		   allDigIn3.setVisibility(View.GONE);
	               allFreqLabel3.setVisibility(View.VISIBLE);
	    	   }
            }
	       allFreqOut3.setOnKeyListener(new OnKeyListener() {
  				@Override
  				public boolean onKey(View v, int keyCode, KeyEvent event)     {
  					switch (keyCode)	{
  					case KeyEvent.KEYCODE_ENTER:
  						int inputted = allFreqOut3.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut3.setText("0");
   							getAllInputString();
   						}
  						return true;
  					}
  					return false;
  				}
  			});
           allFreqOut3.setOnEditorActionListener(new TextView.OnEditorActionListener() {
  				@Override
  				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
   					if (actionId == EditorInfo.IME_ACTION_DONE) {
   						int inputted = allFreqOut3.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut3.setText("0");
   							getAllInputString();
   						}
  						return true;
  					}
  					return false;
  				}
  			});
	       allDigIn4 = (RadioButton)v.findViewById(R.id.all_hi_low4);
           allFreqIn4 = (TextView)v.findViewById(R.id.all_input_freq4);
           allDigOut4 = (CheckBox)v.findViewById(R.id.all_out_hi_low4);
           if (outputState[4]) {
              	allDigOut4.setChecked(true);
           }
           allDigOut4.setOnClickListener(new OnClickListener() {

               @Override
               public void onClick(View v) {
               	if(allDigOut4.isChecked()) {
               		out_hiLow4.setChecked(true);
                   } else {
                   	out_hiLow4.setChecked(false);
                   }
               }
           });
           allFreqOut4 = (EditText)v.findViewById(R.id.all_out_freq4);
           allFreqOut4.setText(desiredFreq[4]);
           allFreqLabel4 = (TextView)v.findViewById(R.id.all_freq_label4);
           allDutyOut4 = (EditText)v.findViewById(R.id.all_out_duty4);
           allDutyOut4.setText(desiredDuty[4]);
           allDutyLabel4 = (TextView)v.findViewById(R.id.all_outduty_label4);
	       if (isOutputCh[4]) { // if channel is output
	    	   allDigIn4.setVisibility(View.GONE); //don't display input widgets
	    	   allFreqIn4.setVisibility(View.GONE);
	    	   if(isDigCh4) { // if channel is digital
	    		   allDigOut4.setVisibility(View.VISIBLE); //display digital widget
	    		   allFreqOut4.setVisibility(View.GONE);
	               allFreqLabel4.setVisibility(View.INVISIBLE);
	               allDutyOut4.setVisibility(View.GONE);
	               allDutyLabel4.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is count
	    		   allFreqOut4.setVisibility(View.VISIBLE); //display count widget
	    		   allDutyOut4.setVisibility(View.VISIBLE);
	    		   allDigOut4.setVisibility(View.GONE);
	               allFreqLabel4.setVisibility(View.VISIBLE);
	               allDutyLabel4.setVisibility(View.VISIBLE);
	    	   }
	       } else { // if channel is input
	    	   allDigOut4.setVisibility(View.GONE); //don't display output widgets
	    	   allFreqOut4.setVisibility(View.GONE);
	    	   allDutyOut4.setVisibility(View.GONE);
	    	   if(isDigCh4) { // if channel is digital 
	    		   allDigIn4.setVisibility(View.VISIBLE); //display digital out widget
	    		   allFreqIn4.setVisibility(View.GONE);
	               allFreqLabel4.setVisibility(View.INVISIBLE);
	               allDutyOut4.setVisibility(View.GONE);
	               allDutyLabel4.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is pulse
	    		   allFreqIn4.setVisibility(View.VISIBLE); // display pulse widget
	    		   allDigIn4.setVisibility(View.GONE);
	               allFreqLabel4.setVisibility(View.VISIBLE);
	    	   }
            }
	       allFreqOut4.setOnKeyListener(new OnKeyListener() {
  				@Override
  				public boolean onKey(View v, int keyCode, KeyEvent event)     {
  					switch (keyCode)	{
  					case KeyEvent.KEYCODE_ENTER:
  						int inputted = allFreqOut4.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut4.setText("0");
   							getAllInputString();
   						}
  						return true;
  					}
  					return false;
  				}
  			});
           allFreqOut4.setOnEditorActionListener(new TextView.OnEditorActionListener() {
  				@Override
  				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
   					if (actionId == EditorInfo.IME_ACTION_DONE) {
   						int inputted = allFreqOut4.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut4.setText("0");
   							getAllInputString();
   						}
  						return true;
  					}
  					return false;
  				}
  			});
	       allDigIn5 = (RadioButton)v.findViewById(R.id.all_hi_low5);
           allFreqIn5 = (TextView)v.findViewById(R.id.all_input_freq5);
           allDigOut5 = (CheckBox)v.findViewById(R.id.all_out_hi_low5);
           if (outputState[5]) {
             	allDigOut5.setChecked(true);
          }
           allDigOut5.setOnClickListener(new OnClickListener() {

               @Override
               public void onClick(View v) {
               	if(allDigOut5.isChecked()) {
               		out_hiLow5.setChecked(true);
                   } else {
                   	out_hiLow5.setChecked(false);
                   }
               }
           });
           allFreqOut5 = (EditText)v.findViewById(R.id.all_out_freq5);
           allFreqOut5.setText(desiredFreq[5]);
           allFreqLabel5 = (TextView)v.findViewById(R.id.all_freq_label5);
           allDutyOut5 = (EditText)v.findViewById(R.id.all_out_duty5);
           allDutyOut5.setText(desiredDuty[5]);
           allDutyLabel5 = (TextView)v.findViewById(R.id.all_outduty_label5);
	       if (isOutputCh[5]) { // if channel is output
	    	   allDigIn5.setVisibility(View.GONE); //don't display input widgets
	    	   allFreqIn5.setVisibility(View.GONE);
	    	   if(isDigCh5) { // if channel is digital
	    		   allDigOut5.setVisibility(View.VISIBLE); //display digital widget
	    		   allFreqOut5.setVisibility(View.GONE);
	               allFreqLabel5.setVisibility(View.INVISIBLE);
	               allDutyOut5.setVisibility(View.GONE);
	               allDutyLabel5.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is count
	    		   allFreqOut5.setVisibility(View.VISIBLE); //display count widget
	    		   allDutyOut5.setVisibility(View.VISIBLE); 
	    		   allDigOut5.setVisibility(View.GONE);
	               allFreqLabel5.setVisibility(View.VISIBLE);
	               allDutyLabel5.setVisibility(View.VISIBLE);
	    	   }
	       } else { // if channel is input
	    	   allDigOut5.setVisibility(View.GONE); //don't display output widgets
	    	   allFreqOut5.setVisibility(View.GONE);
	    	   allDutyOut5.setVisibility(View.GONE);
	    	   if(isDigCh5) { // if channel is digital 
	    		   allDigIn5.setVisibility(View.VISIBLE); //display digital out widget
	    		   allFreqIn5.setVisibility(View.GONE);
	               allFreqLabel5.setVisibility(View.INVISIBLE);
	               allDutyOut5.setVisibility(View.GONE);
	               allDutyLabel5.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is pulse
	    		   allFreqIn5.setVisibility(View.VISIBLE); // display pulse widget
	    		   allDigIn5.setVisibility(View.GONE);
	               allFreqLabel5.setVisibility(View.VISIBLE);
	    	   }
            }
	       allFreqOut5.setOnKeyListener(new OnKeyListener() {
  				@Override
  				public boolean onKey(View v, int keyCode, KeyEvent event)     {
  					switch (keyCode)	{
  					case KeyEvent.KEYCODE_ENTER:
  						int inputted = allFreqOut5.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut5.setText("0");
   							getAllInputString();
   						}
  						return true;
  					}
  					return false;
  				}
  			});
           allFreqOut5.setOnEditorActionListener(new TextView.OnEditorActionListener() {
  				@Override
  				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
   					if (actionId == EditorInfo.IME_ACTION_DONE) {
   						int inputted = allFreqOut5.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut5.setText("0");
   							getAllInputString();
   						}
  						return true;
  					}
  					return false;
  				}
  			});
	       allDigIn6 = (RadioButton)v.findViewById(R.id.all_hi_low6);
           allFreqIn6 = (TextView)v.findViewById(R.id.all_input_freq6);
           allDigOut6 = (CheckBox)v.findViewById(R.id.all_out_hi_low6);
           if (outputState[6]) {
             	allDigOut6.setChecked(true);
          }
           allDigOut6.setOnClickListener(new OnClickListener() {

               @Override
               public void onClick(View v) {
               	if(allDigOut6.isChecked()) {
               		out_hiLow6.setChecked(true);
                   } else {
                   	out_hiLow6.setChecked(false);
                   }
               }
           });
           allFreqOut6 = (EditText)v.findViewById(R.id.all_out_freq6);
           allFreqOut6.setText(desiredFreq[6]);
           allFreqLabel6 = (TextView)v.findViewById(R.id.all_freq_label6);
           allDutyOut6 = (EditText)v.findViewById(R.id.all_out_duty6);
           allDutyOut6.setText(desiredDuty[6]);
           allDutyLabel6 = (TextView)v.findViewById(R.id.all_outduty_label6);
           if (isOutputCh[6]) { // if channel is output
	    	   allDigIn6.setVisibility(View.GONE); //don't display input widgets
	    	   allFreqIn6.setVisibility(View.GONE);
	    	   if(isDigCh6) { // if channel is digital
	    		   allDigOut6.setVisibility(View.VISIBLE); //display digital widget
	    		   allFreqOut6.setVisibility(View.GONE);
	               allFreqLabel6.setVisibility(View.INVISIBLE);
	               allDutyOut6.setVisibility(View.GONE);
	               allDutyLabel6.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is count
	    		   allFreqOut6.setVisibility(View.VISIBLE); //display count widget
	    		   allDutyOut6.setVisibility(View.VISIBLE); 
	    		   allDigOut6.setVisibility(View.GONE);
	               allFreqLabel6.setVisibility(View.VISIBLE);
	               allDutyLabel6.setVisibility(View.VISIBLE);
	    	   }
	       } else { // if channel is input
	    	   allDigOut6.setVisibility(View.GONE); //don't display output widgets
	    	   allFreqOut6.setVisibility(View.GONE);
	    	   allDutyOut6.setVisibility(View.GONE);
	    	   if(isDigCh6) { // if channel is digital 
	    		   allDigIn6.setVisibility(View.VISIBLE); //display digital out widget
	    		   allFreqIn6.setVisibility(View.GONE);
	               allFreqLabel6.setVisibility(View.INVISIBLE);
	               allDutyOut6.setVisibility(View.GONE);
	               allDutyLabel6.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is pulse
	    		   allFreqIn6.setVisibility(View.VISIBLE); // display pulse widget
	    		   allDigIn6.setVisibility(View.GONE);
	               allFreqLabel6.setVisibility(View.VISIBLE);
	    	   }
            }
	       allFreqOut6.setOnKeyListener(new OnKeyListener() {
  				@Override
  				public boolean onKey(View v, int keyCode, KeyEvent event)     {
  					switch (keyCode)	{
  					case KeyEvent.KEYCODE_ENTER:
  						int inputted = allFreqOut6.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut6.setText("0");
   							getAllInputString();
   						}
  						return true;
  					}
  					return false;
  				}
  			});
           allFreqOut6.setOnEditorActionListener(new TextView.OnEditorActionListener() {
  				@Override
  				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
   					if (actionId == EditorInfo.IME_ACTION_DONE) {
   						int inputted = allFreqOut6.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut6.setText("0");
   							getAllInputString();
   						}
  						return true;
  					}
  					return false;
  				}
  			});
	       allDigIn7 = (RadioButton)v.findViewById(R.id.all_hi_low7);
           allFreqIn7 = (TextView)v.findViewById(R.id.all_input_freq7);
           allDigOut7 = (CheckBox)v.findViewById(R.id.all_out_hi_low7);
           if (outputState[7]) {
             	allDigOut7.setChecked(true);
          }
           allDigOut7.setOnClickListener(new OnClickListener() {

               @Override
               public void onClick(View v) {
               	if(allDigOut7.isChecked()) {
               		out_hiLow7.setChecked(true);
                   } else {
                   	out_hiLow7.setChecked(false);
                   }
               }
           });
           allFreqOut7 = (EditText)v.findViewById(R.id.all_out_freq7);
           allFreqOut7.setText(desiredFreq[7]);
           allFreqLabel7 = (TextView)v.findViewById(R.id.all_freq_label7);
           allDutyOut7 = (EditText)v.findViewById(R.id.all_out_duty7);
           allDutyOut7.setText(desiredDuty[7]);
           allDutyLabel7 = (TextView)v.findViewById(R.id.all_outduty_label7);
	       if (isOutputCh[7]) { // if channel is output
	    	   allDigIn7.setVisibility(View.GONE); //don't display input widgets
	    	   allFreqIn7.setVisibility(View.GONE);
	    	   if(isDigCh7) { // if channel is digital
	    		   allDigOut7.setVisibility(View.VISIBLE); //display digital widget
	    		   allFreqOut7.setVisibility(View.GONE);
	               allFreqLabel7.setVisibility(View.INVISIBLE);
	               allDutyOut7.setVisibility(View.GONE);
	               allDutyLabel7.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is count
	    		   allFreqOut7.setVisibility(View.VISIBLE); //display count widget
	    		   allDutyOut7.setVisibility(View.VISIBLE);
	    		   allDigOut7.setVisibility(View.GONE);
	               allFreqLabel7.setVisibility(View.VISIBLE);
	               allDutyLabel7.setVisibility(View.VISIBLE);
	    	   }
	       } else { // if channel is input
	    	   allDigOut7.setVisibility(View.GONE); //don't display output widgets
	    	   allFreqOut7.setVisibility(View.GONE);
	    	   allDutyOut7.setVisibility(View.GONE);
	    	   if(isDigCh7) { // if channel is digital 
	    		   allDigIn7.setVisibility(View.VISIBLE); //display digital out widget
	    		   allFreqIn7.setVisibility(View.GONE);
	               allFreqLabel7.setVisibility(View.INVISIBLE);
	               allDutyOut7.setVisibility(View.GONE);
	               allDutyLabel7.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is pulse
	    		   allFreqIn7.setVisibility(View.VISIBLE); // display pulse widget
	    		   allDigIn7.setVisibility(View.GONE);
	               allFreqLabel7.setVisibility(View.VISIBLE);
	    	   }
            }
	       allFreqOut7.setOnKeyListener(new OnKeyListener() {
  				@Override
  				public boolean onKey(View v, int keyCode, KeyEvent event)     {
  					switch (keyCode)	{
  					case KeyEvent.KEYCODE_ENTER:
  						int inputted = allFreqOut7.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut7.setText("0");
   							getAllInputString();
   						}
  						return true;
  					}
  					return false;
  				}
  			});
           allFreqOut7.setOnEditorActionListener(new TextView.OnEditorActionListener() {
  				@Override
  				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
   					if (actionId == EditorInfo.IME_ACTION_DONE) {
   						int inputted = allFreqOut7.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut7.setText("0");
   							getAllInputString();
   						}
  						return true;
  					}
  					return false;
  				}
  			});
	       allDigIn8 = (RadioButton)v.findViewById(R.id.all_hi_low8);
           allFreqIn8 = (TextView)v.findViewById(R.id.all_input_freq8);
           allDigOut8 = (CheckBox)v.findViewById(R.id.all_out_hi_low8);
           if (outputState[8]) {
             	allDigOut8.setChecked(true);
          }
           allDigOut8.setOnClickListener(new OnClickListener() {

               @Override
               public void onClick(View v) {
               	if(allDigOut8.isChecked()) {
               		out_hiLow8.setChecked(true);
                   } else {
                   	out_hiLow8.setChecked(false);
                   }
               }
           });
           allFreqOut8 = (EditText)v.findViewById(R.id.all_out_freq8);
           allFreqOut8.setText(desiredFreq[8]);
           allFreqLabel8 = (TextView)v.findViewById(R.id.all_freq_label8);
           allDutyOut8 = (EditText)v.findViewById(R.id.all_out_duty8);
           allDutyOut8.setText(desiredDuty[8]);
           allDutyLabel8 = (TextView)v.findViewById(R.id.all_outduty_label8);
	       if (isOutputCh[8]) { // if channel is output
	    	   allDigIn8.setVisibility(View.GONE); //don't display input widgets
	    	   allFreqIn8.setVisibility(View.GONE);
	    	   if(isDigCh8) { // if channel is digital
	    		   allDigOut8.setVisibility(View.VISIBLE); //display digital widget
	    		   allFreqOut8.setVisibility(View.GONE);
	               allFreqLabel8.setVisibility(View.INVISIBLE);
	               allDutyOut8.setVisibility(View.GONE);
	               allDutyLabel8.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is count
	    		   allFreqOut8.setVisibility(View.VISIBLE); //display count widget
	    		   allDutyOut8.setVisibility(View.VISIBLE);
	    		   allDigOut8.setVisibility(View.GONE);
	               allFreqLabel8.setVisibility(View.VISIBLE);
	               allDutyLabel8.setVisibility(View.VISIBLE);
	    	   }
	       } else { // if channel is input
	    	   allDigOut8.setVisibility(View.GONE); //don't display output widgets
	    	   allFreqOut8.setVisibility(View.GONE);
	    	   allDutyOut8.setVisibility(View.GONE);
	    	   if(isDigCh8) { // if channel is digital 
	    		   allDigIn8.setVisibility(View.VISIBLE); //display digital out widget
	    		   allFreqIn8.setVisibility(View.GONE);
	               allFreqLabel8.setVisibility(View.INVISIBLE);
	               allDutyOut8.setVisibility(View.GONE);
	               allDutyLabel8.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is pulse
	    		   allFreqIn8.setVisibility(View.VISIBLE); // display pulse widget
	    		   allDigIn8.setVisibility(View.GONE);
	               allFreqLabel8.setVisibility(View.VISIBLE);
	    	   }
            }
	       allFreqOut8.setOnKeyListener(new OnKeyListener() {
  				@Override
  				public boolean onKey(View v, int keyCode, KeyEvent event)     {
  					switch (keyCode)	{
  					case KeyEvent.KEYCODE_ENTER:
  						int inputted = allFreqOut8.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut8.setText("0");
   							getAllInputString();
   						}
  						return true;
  					}
  					return false;
  				}
  			});
           allFreqOut8.setOnEditorActionListener(new TextView.OnEditorActionListener() {
  				@Override
  				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
   					if (actionId == EditorInfo.IME_ACTION_DONE) {
   						int inputted = allFreqOut8.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut8.setText("0");
   							getAllInputString();
   						}
  						return true;
  					}
  					return false;
  				}
  			});
	       allDigIn9 = (RadioButton)v.findViewById(R.id.all_hi_low9);
           allFreqIn9 = (TextView)v.findViewById(R.id.all_input_freq9);
           allDigOut9 = (CheckBox)v.findViewById(R.id.all_out_hi_low9);
           if (outputState[9]) {
             	allDigOut9.setChecked(true);
          }
           allDigOut9.setOnClickListener(new OnClickListener() {

               @Override
               public void onClick(View v) {
               	if(allDigOut9.isChecked()) {
               		out_hiLow9.setChecked(true);
                   } else {
                   	out_hiLow9.setChecked(false);
                   }
               }
           });
           allFreqOut9 = (EditText)v.findViewById(R.id.all_out_freq9);
           allFreqOut9.setText(desiredFreq[9]);
           allFreqLabel9 = (TextView)v.findViewById(R.id.all_freq_label9);
           allDutyOut9 = (EditText)v.findViewById(R.id.all_out_duty9);
           allDutyOut9.setText(desiredDuty[9]);
           allDutyLabel9 = (TextView)v.findViewById(R.id.all_outduty_label9);
	       if (isOutputCh[9]) { // if channel is output
	    	   allDigIn9.setVisibility(View.GONE); //don't display input widgets
	    	   allFreqIn9.setVisibility(View.GONE);
	    	   if(isDigCh9) { // if channel is digital
	    		   allDigOut9.setVisibility(View.VISIBLE); //display digital widget
	    		   allFreqOut9.setVisibility(View.GONE);
	               allFreqLabel9.setVisibility(View.INVISIBLE);
	               allDutyOut9.setVisibility(View.GONE);
	               allDutyLabel9.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is count
	    		   allFreqOut9.setVisibility(View.VISIBLE); //display count widget
	    		   allDutyOut9.setVisibility(View.VISIBLE);
	    		   allDigOut9.setVisibility(View.GONE);
	               allFreqLabel9.setVisibility(View.VISIBLE);
	               allDutyLabel9.setVisibility(View.VISIBLE);
	    	   }
	       } else { // if channel is input
	    	   allDigOut9.setVisibility(View.GONE); //don't display output widgets
	    	   allFreqOut9.setVisibility(View.GONE);
	    	   allDutyOut9.setVisibility(View.GONE);
	    	   if(isDigCh9) { // if channel is digital 
	    		   allDigIn9.setVisibility(View.VISIBLE); //display digital out widget
	    		   allFreqIn9.setVisibility(View.GONE);
	               allFreqLabel9.setVisibility(View.INVISIBLE);
	               allDutyOut9.setVisibility(View.GONE);
	               allDutyLabel9.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is pulse
	    		   allFreqIn9.setVisibility(View.VISIBLE); // display pulse widget
	    		   allDigIn9.setVisibility(View.GONE);
	               allFreqLabel9.setVisibility(View.VISIBLE);
	    	   }
            }
	       allFreqOut9.setOnKeyListener(new OnKeyListener() {
 				@Override
 				public boolean onKey(View v, int keyCode, KeyEvent event)     {
 					switch (keyCode)	{
 					case KeyEvent.KEYCODE_ENTER:
 						int inputted = allFreqOut9.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut9.setText("0");
   							getAllInputString();
   						}
 						return true;
 					}
 					return false;
 				}
 			});
          allFreqOut9.setOnEditorActionListener(new TextView.OnEditorActionListener() {
 				@Override
 				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
  					if (actionId == EditorInfo.IME_ACTION_DONE) {
  						int inputted = allFreqOut9.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut9.setText("0");
   							getAllInputString();
   						}
 						return true;
 					}
 					return false;
 				}
 			});
	       allDigIn10 = (RadioButton)v.findViewById(R.id.all_hi_low10);
           allFreqIn10 = (TextView)v.findViewById(R.id.all_input_freq10);
           allDigOut10 = (CheckBox)v.findViewById(R.id.all_out_hi_low10);
           if (outputState[10]) {
             	allDigOut10.setChecked(true);
          }
           allDigOut10.setOnClickListener(new OnClickListener() {

               @Override
               public void onClick(View v) {
               	if(allDigOut10.isChecked()) {
               		out_hiLow10.setChecked(true);
                   } else {
                   	out_hiLow10.setChecked(false);
                   }
               }
           });
           allFreqOut10 = (EditText)v.findViewById(R.id.all_out_freq10);
           allFreqOut10.setText(desiredFreq[10]);
           allFreqLabel10 = (TextView)v.findViewById(R.id.all_freq_label10);
           allDutyOut10 = (EditText)v.findViewById(R.id.all_out_duty10);
           allDutyOut10.setText(desiredDuty[10]);
           allDutyLabel10 = (TextView)v.findViewById(R.id.all_outduty_label10);
	       if (isOutputCh[10]) { // if channel is output
	    	   allDigIn10.setVisibility(View.GONE); //don't display input widgets
	    	   allFreqIn10.setVisibility(View.GONE);
	    	   if(isDigCh10) { // if channel is digital
	    		   allDigOut10.setVisibility(View.VISIBLE); //display digital widget
	    		   allFreqOut10.setVisibility(View.GONE);
	               allFreqLabel10.setVisibility(View.INVISIBLE);
	               allDutyOut10.setVisibility(View.GONE);
	               allDutyLabel10.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is count
	    		   allFreqOut10.setVisibility(View.VISIBLE); //display count widget
	    		   allDutyOut10.setVisibility(View.VISIBLE);
	    		   allDigOut10.setVisibility(View.GONE);
	               allFreqLabel10.setVisibility(View.VISIBLE);
	               allDutyLabel10.setVisibility(View.VISIBLE);
	    	   }
	       } else { // if channel is input
	    	   allDigOut10.setVisibility(View.GONE); //don't display output widgets
	    	   allFreqOut10.setVisibility(View.GONE);
	    	   allDutyOut10.setVisibility(View.GONE);
	    	   if(isDigCh10) { // if channel is digital 
	    		   allDigIn10.setVisibility(View.VISIBLE); //display digital out widget
	    		   allFreqIn10.setVisibility(View.GONE);
	               allFreqLabel10.setVisibility(View.INVISIBLE);
	               allDutyOut10.setVisibility(View.GONE);
	               allDutyLabel10.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is pulse
	    		   allFreqIn10.setVisibility(View.VISIBLE); // display pulse widget
	    		   allDigIn10.setVisibility(View.GONE);
	               allFreqLabel10.setVisibility(View.VISIBLE);
	    	   }
            }
	       allFreqOut10.setOnKeyListener(new OnKeyListener() {
 				@Override
 				public boolean onKey(View v, int keyCode, KeyEvent event)     {
 					switch (keyCode)	{
 					case KeyEvent.KEYCODE_ENTER:
 						int inputted = allFreqOut10.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut10.setText("0");
   							getAllInputString();
   						}
 						return true;
 					}
 					return false;
 				}
 			});
          allFreqOut10.setOnEditorActionListener(new TextView.OnEditorActionListener() {
 				@Override
 				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
  					if (actionId == EditorInfo.IME_ACTION_DONE) {
  						int inputted = allFreqOut10.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut10.setText("0");
   							getAllInputString();
   						}
 						return true;
 					}
 					return false;
 				}
 			});
	       allDigIn11 = (RadioButton)v.findViewById(R.id.all_hi_low11);
           allFreqIn11 = (TextView)v.findViewById(R.id.all_input_freq11);
           allDigOut11 = (CheckBox)v.findViewById(R.id.all_out_hi_low11);
           if (outputState[11]) {
             	allDigOut11.setChecked(true);
          }
           allDigOut11.setOnClickListener(new OnClickListener() {

               @Override
               public void onClick(View v) {
               	if(allDigOut11.isChecked()) {
               		out_hiLow11.setChecked(true);
                   } else {
                   	out_hiLow11.setChecked(false);
                   }
               }
           });
           allFreqOut11 = (EditText)v.findViewById(R.id.all_out_freq11);
           allFreqOut11.setText(desiredFreq[11]);
           allFreqLabel11 = (TextView)v.findViewById(R.id.all_freq_label11);
           allDutyOut11 = (EditText)v.findViewById(R.id.all_out_duty11);
           allDutyOut11.setText(desiredDuty[11]);
           allDutyLabel11 = (TextView)v.findViewById(R.id.all_outduty_label11);
	       if (isOutputCh[11]) { // if channel is output
	    	   allDigIn11.setVisibility(View.GONE); //don't display input widgets
	    	   allFreqIn11.setVisibility(View.GONE);
	    	   if(isDigCh11) { // if channel is digital
	    		   allDigOut11.setVisibility(View.VISIBLE); //display digital widget
	    		   allFreqOut11.setVisibility(View.GONE);
	               allFreqLabel11.setVisibility(View.INVISIBLE);
	               allDutyOut11.setVisibility(View.GONE);
	               allDutyLabel11.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is count
	    		   allFreqOut11.setVisibility(View.VISIBLE); //display count widget
	    		   allDutyOut11.setVisibility(View.VISIBLE);
	    		   allDigOut11.setVisibility(View.GONE);
	               allFreqLabel11.setVisibility(View.VISIBLE);
	               allDutyLabel11.setVisibility(View.VISIBLE);
	    	   }
	       } else { // if channel is input
	    	   allDigOut11.setVisibility(View.GONE); //don't display output widgets
	    	   allFreqOut11.setVisibility(View.GONE);
	    	   allDutyOut11.setVisibility(View.GONE);
	    	   if(isDigCh11) { // if channel is digital 
	    		   allDigIn11.setVisibility(View.VISIBLE); //display digital out widget
	    		   allFreqIn11.setVisibility(View.GONE);
	               allFreqLabel11.setVisibility(View.INVISIBLE);
	               allDutyOut11.setVisibility(View.GONE);
	               allDutyLabel11.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is pulse
	    		   allFreqIn11.setVisibility(View.VISIBLE); // display pulse widget
	    		   allDigIn11.setVisibility(View.GONE);
	               allFreqLabel11.setVisibility(View.VISIBLE);
	    	   }
            } 
	       allFreqOut11.setOnKeyListener(new OnKeyListener() {
 				@Override
 				public boolean onKey(View v, int keyCode, KeyEvent event)     {
 					switch (keyCode)	{
 					case KeyEvent.KEYCODE_ENTER:
 						int inputted = allFreqOut11.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut11.setText("0");
   							getAllInputString();
   						}
 						return true;
 					}
 					return false;
 				}
 			});
          allFreqOut11.setOnEditorActionListener(new TextView.OnEditorActionListener() {
 				@Override
 				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
  					if (actionId == EditorInfo.IME_ACTION_DONE) {
  						int inputted = allFreqOut11.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut11.setText("0");
   							getAllInputString();
   						}
 						return true;
 					}
 					return false;
 				}
 			});
	       allDigIn12 = (RadioButton)v.findViewById(R.id.all_hi_low12);
           allFreqIn12 = (TextView)v.findViewById(R.id.all_input_freq12);
           allDigOut12 = (CheckBox)v.findViewById(R.id.all_out_hi_low12);
           if (outputState[12]) {
             	allDigOut12.setChecked(true);
          }
           allDigOut12.setOnClickListener(new OnClickListener() {

               @Override
               public void onClick(View v) {
               	if(allDigOut12.isChecked()) {
               		out_hiLow12.setChecked(true);
                   } else {
                   	out_hiLow12.setChecked(false);
                   }
               }
           });
           allFreqOut12 = (EditText)v.findViewById(R.id.all_out_freq12);
           allFreqOut12.setText(desiredFreq[12]);
           allFreqLabel12 = (TextView)v.findViewById(R.id.all_freq_label12);
           allDutyOut12 = (EditText)v.findViewById(R.id.all_out_duty12);
           allDutyOut12.setText(desiredDuty[12]);
           allDutyLabel12 = (TextView)v.findViewById(R.id.all_outduty_label12);
	       if (isOutputCh[12]) { // if channel is output
	    	   allDigIn12.setVisibility(View.GONE); //don't display input widgets
	    	   allFreqIn12.setVisibility(View.GONE);
	    	   if(isDigCh12) { // if channel is digital
	    		   allDigOut12.setVisibility(View.VISIBLE); //display digital widget
	    		   allFreqOut12.setVisibility(View.GONE);
	               allFreqLabel12.setVisibility(View.INVISIBLE);
	               allDutyOut12.setVisibility(View.GONE);
	               allDutyLabel12.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is count
	    		   allFreqOut12.setVisibility(View.VISIBLE); //display count widget
	    		   allDutyOut12.setVisibility(View.VISIBLE);
	    		   allDigOut12.setVisibility(View.GONE);
	               allFreqLabel12.setVisibility(View.VISIBLE);
	               allDutyLabel12.setVisibility(View.VISIBLE);
	    	   }
	       } else { // if channel is input
	    	   allDigOut12.setVisibility(View.GONE); //don't display output widgets
	    	   allFreqOut12.setVisibility(View.GONE);
	    	   allDutyOut12.setVisibility(View.GONE);
	    	   if(isDigCh12) { // if channel is digital 
	    		   allDigIn12.setVisibility(View.VISIBLE); //display digital out widget
	    		   allFreqIn12.setVisibility(View.GONE);
	               allFreqLabel12.setVisibility(View.INVISIBLE);
	               allDutyOut12.setVisibility(View.GONE);
	               allDutyLabel12.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is pulse
	    		   allFreqIn12.setVisibility(View.VISIBLE); // display pulse widget
	    		   allDigIn12.setVisibility(View.GONE);
	               allFreqLabel12.setVisibility(View.VISIBLE);
	    	   }
            }
	       allFreqOut12.setOnKeyListener(new OnKeyListener() {
 				@Override
 				public boolean onKey(View v, int keyCode, KeyEvent event)     {
 					switch (keyCode)	{
 					case KeyEvent.KEYCODE_ENTER:
 						int inputted = allFreqOut12.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut12.setText("0");
   							getAllInputString();
   						}
 						return true;
 					}
 					return false;
 				}
 			});
          allFreqOut12.setOnEditorActionListener(new TextView.OnEditorActionListener() {
 				@Override
 				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
  					if (actionId == EditorInfo.IME_ACTION_DONE) {
  						int inputted = allFreqOut12.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut12.setText("0");
   							getAllInputString();
   						}
 						return true;
 					}
 					return false;
 				}
 			});
	       allDigIn13 = (RadioButton)v.findViewById(R.id.all_hi_low13);
           allFreqIn13 = (TextView)v.findViewById(R.id.all_input_freq13);
           allDigOut13 = (CheckBox)v.findViewById(R.id.all_out_hi_low13);
           if (outputState[13]) {
             	allDigOut13.setChecked(true);
          }
           allDigOut13.setOnClickListener(new OnClickListener() {

               @Override
               public void onClick(View v) {
               	if(allDigOut13.isChecked()) {
               		out_hiLow13.setChecked(true);
                   } else {
                   	out_hiLow13.setChecked(false);
                   }
               }
           });
           allFreqOut13 = (EditText)v.findViewById(R.id.all_out_freq13);
           allFreqOut13.setText(desiredFreq[13]);
           allFreqLabel13 = (TextView)v.findViewById(R.id.all_freq_label13);
           allDutyOut13 = (EditText)v.findViewById(R.id.all_out_duty13);
           allDutyOut13.setText(desiredDuty[13]);
           allDutyLabel13 = (TextView)v.findViewById(R.id.all_outduty_label13);
	       if (isOutputCh[13]) { // if channel is output
	    	   allDigIn13.setVisibility(View.GONE); //don't display input widgets
	    	   allFreqIn13.setVisibility(View.GONE);
	    	   if(isDigCh13) { // if channel is digital
	    		   allDigOut13.setVisibility(View.VISIBLE); //display digital widget
	    		   allFreqOut13.setVisibility(View.GONE);
	               allFreqLabel13.setVisibility(View.INVISIBLE);
	               allDutyOut13.setVisibility(View.GONE);
	               allDutyLabel13.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is count
	    		   allFreqOut13.setVisibility(View.VISIBLE); //display count widget
	    		   allDutyOut13.setVisibility(View.VISIBLE);
	    		   allDigOut13.setVisibility(View.GONE);
	               allFreqLabel13.setVisibility(View.VISIBLE);
	               allDutyLabel13.setVisibility(View.VISIBLE);
	    	   }
	       } else { // if channel is input
	    	   allDigOut13.setVisibility(View.GONE); //don't display output widgets
	    	   allFreqOut13.setVisibility(View.GONE);
	    	   allDutyOut13.setVisibility(View.GONE);
	    	   if(isDigCh13) { // if channel is digital 
	    		   allDigIn13.setVisibility(View.VISIBLE); //display digital out widget
	    		   allFreqIn13.setVisibility(View.GONE);
	               allFreqLabel13.setVisibility(View.INVISIBLE);
	               allDutyOut13.setVisibility(View.GONE);
	               allDutyLabel13.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is pulse
	    		   allFreqIn13.setVisibility(View.VISIBLE); // display pulse widget
	    		   allDigIn13.setVisibility(View.GONE);
	               allFreqLabel13.setVisibility(View.VISIBLE);
	    	   }
            }
	       allFreqOut13.setOnKeyListener(new OnKeyListener() {
 				@Override
 				public boolean onKey(View v, int keyCode, KeyEvent event)     {
 					switch (keyCode)	{
 					case KeyEvent.KEYCODE_ENTER:
 						int inputted = allFreqOut13.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut13.setText("0");
   							getAllInputString();
   						}
 						return true;
 					}
 					return false;
 				}
 			});
          allFreqOut13.setOnEditorActionListener(new TextView.OnEditorActionListener() {
 				@Override
 				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
  					if (actionId == EditorInfo.IME_ACTION_DONE) {
  						int inputted = allFreqOut13.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut13.setText("0");
   							getAllInputString();
   						}
 						return true;
 					}
 					return false;
 				}
 			});
	       allDigIn14 = (RadioButton)v.findViewById(R.id.all_hi_low14);
           allFreqIn14 = (TextView)v.findViewById(R.id.all_input_freq14);
           allDigOut14 = (CheckBox)v.findViewById(R.id.all_out_hi_low14);
           if (outputState[14]) {
             	allDigOut14.setChecked(true);
          }
           allDigOut14.setOnClickListener(new OnClickListener() {

               @Override
               public void onClick(View v) {
               	if(allDigOut14.isChecked()) {
               		out_hiLow14.setChecked(true);
                   } else {
                   	out_hiLow14.setChecked(false);
                   }
               }
           });
           allFreqOut14 = (EditText)v.findViewById(R.id.all_out_freq14);
           allFreqOut14.setText(desiredFreq[14]);
           allFreqLabel14 = (TextView)v.findViewById(R.id.all_freq_label14);
           allDutyOut14 = (EditText)v.findViewById(R.id.all_out_duty14);
           allDutyOut14.setText(desiredDuty[14]);
           allDutyLabel14 = (TextView)v.findViewById(R.id.all_outduty_label14);
	       if (isOutputCh[14]) { // if channel is output
	    	   allDigIn14.setVisibility(View.GONE); //don't display input widgets
	    	   allFreqIn14.setVisibility(View.GONE);
	    	   if(isDigCh14) { // if channel is digital
	    		   allDigOut14.setVisibility(View.VISIBLE); //display digital widget
	    		   allFreqOut14.setVisibility(View.GONE);
	               allFreqLabel14.setVisibility(View.INVISIBLE);
	               allDutyOut14.setVisibility(View.GONE);
	               allDutyLabel14.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is count
	    		   allFreqOut14.setVisibility(View.VISIBLE); //display count widget
	    		   allDutyOut14.setVisibility(View.VISIBLE);
	    		   allDigOut14.setVisibility(View.GONE);
	    		   allFreqLabel14.setVisibility(View.VISIBLE);
	    		   allDutyLabel14.setVisibility(View.VISIBLE);
	    	   }
	       } else { // if channel is input
	    	   allDigOut14.setVisibility(View.GONE); //don't display output widgets
	    	   allFreqOut14.setVisibility(View.GONE);
	    	   allDutyOut14.setVisibility(View.GONE);
	    	   if(isDigCh14) { // if channel is digital 
	    		   allDigIn14.setVisibility(View.VISIBLE); //display digital out widget
	    		   allFreqIn14.setVisibility(View.GONE);
	    		   allFreqLabel14.setVisibility(View.INVISIBLE);
	    		   allDutyOut14.setVisibility(View.GONE);
	               allDutyLabel14.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is pulse
	    		   allFreqIn14.setVisibility(View.VISIBLE); // display pulse widget
	    		   allDigIn14.setVisibility(View.GONE);
	    		   allFreqLabel14.setVisibility(View.VISIBLE);
	    	   }
            }
	       allFreqOut14.setOnKeyListener(new OnKeyListener() {
 				@Override
 				public boolean onKey(View v, int keyCode, KeyEvent event)     {
 					switch (keyCode)	{
 					case KeyEvent.KEYCODE_ENTER:
 						int inputted = allFreqOut14.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut14.setText("0");
   							getAllInputString();
   						}
 						return true;
 					}
 					return false;
 				}
 			});
          allFreqOut14.setOnEditorActionListener(new TextView.OnEditorActionListener() {
 				@Override
 				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
  					if (actionId == EditorInfo.IME_ACTION_DONE) {
  						int inputted = allFreqOut14.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut14.setText("0");
   							getAllInputString();
   						}
 						return true;
 					}
 					return false;
 				}
 			});
	       allDigIn15 = (RadioButton)v.findViewById(R.id.all_hi_low15);
           allFreqIn15 = (TextView)v.findViewById(R.id.all_input_freq15);
           allDigOut15 = (CheckBox)v.findViewById(R.id.all_out_hi_low15);
           if (outputState[15]) {
             	allDigOut15.setChecked(true);
          }
           allDigOut15.setOnClickListener(new OnClickListener() {

               @Override
               public void onClick(View v) {
               	if(allDigOut15.isChecked()) {
               		out_hiLow15.setChecked(true);
                   } else {
                   	out_hiLow15.setChecked(false);
                   }
               }
           });
           allFreqOut15 = (EditText)v.findViewById(R.id.all_out_freq15);
           allFreqOut15.setText(desiredFreq[15]);
           allFreqLabel15 = (TextView)v.findViewById(R.id.all_freq_label15);
           allDutyOut15 = (EditText)v.findViewById(R.id.all_out_duty15);
           allDutyOut15.setText(desiredDuty[15]);
           allDutyLabel15 = (TextView)v.findViewById(R.id.all_outduty_label15);
	       if (isOutputCh[15]) { // if channel is output
	    	   allDigIn15.setVisibility(View.GONE); //don't display input widgets
	    	   allFreqIn15.setVisibility(View.GONE);
	    	   if(isDigCh15) { // if channel is digital
	    		   allDigOut15.setVisibility(View.VISIBLE); //display digital widget
	    		   allFreqOut15.setVisibility(View.GONE);
	               allFreqLabel15.setVisibility(View.INVISIBLE);
	               allDutyOut15.setVisibility(View.GONE);
	               allDutyLabel15.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is count
	    		   allFreqOut15.setVisibility(View.VISIBLE); //display count widget
	    		   allDutyOut15.setVisibility(View.VISIBLE);
	    		   allDigOut15.setVisibility(View.GONE);
	               allFreqLabel15.setVisibility(View.VISIBLE);
	               allDutyLabel15.setVisibility(View.VISIBLE);
	    	   }
	       } else { // if channel is input
	    	   allDigOut15.setVisibility(View.GONE); //don't display output widgets
	    	   allFreqOut15.setVisibility(View.GONE);
	    	   allDutyOut15.setVisibility(View.GONE);
	    	   if(isDigCh15) { // if channel is digital 
	    		   allDigIn15.setVisibility(View.VISIBLE); //display digital out widget
	    		   allFreqIn15.setVisibility(View.GONE);
	               allFreqLabel15.setVisibility(View.INVISIBLE);
	               allDutyOut15.setVisibility(View.GONE);
	               allDutyLabel15.setVisibility(View.INVISIBLE);
	    	   } else { // if channel is pulse
	    		   allFreqIn15.setVisibility(View.VISIBLE); // display pulse widget
	    		   allDigIn15.setVisibility(View.GONE);
	               allFreqLabel15.setVisibility(View.VISIBLE);
	    	   }
            }
	       allFreqOut15.setOnKeyListener(new OnKeyListener() {
 				@Override
 				public boolean onKey(View v, int keyCode, KeyEvent event)     {
 					switch (keyCode)	{
 					case KeyEvent.KEYCODE_ENTER:
 						int inputted = allFreqOut15.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut15.setText("0");
   							getAllInputString();
   						}
 						return true;
 					}
 					return false;
 				}
 			});
          allFreqOut15.setOnEditorActionListener(new TextView.OnEditorActionListener() {
 				@Override
 				public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
  					if (actionId == EditorInfo.IME_ACTION_DONE) {
  						int inputted = allFreqOut15.getText().toString().length();
   						if (inputted > 0) {
   							getAllInputString();
   						} else {
   							allFreqOut15.setText("0");
   							getAllInputString();
   						}
 						return true;
 					}
 					return false;
 				}
 			});
	       allVoltCh0 = (TextView)v.findViewById(R.id.volt_ch_0);
	       allVoltReading0 = (TextView)v.findViewById(R.id.all_input_volts0);
	       allVoltLabel0 = (TextView)v.findViewById(R.id.volt_label_0);
	       allVoltCh1 = (TextView)v.findViewById(R.id.volt_ch_1);
	       allVoltReading1 = (TextView)v.findViewById(R.id.all_input_volts1);
	       allVoltLabel1 = (TextView)v.findViewById(R.id.volt_label_1);
	       allVoltCh2 = (TextView)v.findViewById(R.id.volt_ch_2);
	       allVoltReading2 = (TextView)v.findViewById(R.id.all_input_volts2);
	       allVoltLabel2 = (TextView)v.findViewById(R.id.volt_label_2);
	       allVoltCh3 = (TextView)v.findViewById(R.id.volt_ch_3);
	       allVoltReading3 = (TextView)v.findViewById(R.id.all_input_volts3);
	       allVoltLabel3 = (TextView)v.findViewById(R.id.volt_label_3);
	       allVoltCh4 = (TextView)v.findViewById(R.id.volt_ch_4);
	       allVoltReading4 = (TextView)v.findViewById(R.id.all_input_volts4);
	       allVoltLabel4 = (TextView)v.findViewById(R.id.volt_label_4);
	       allVoltCh5 = (TextView)v.findViewById(R.id.volt_ch_5);
	       allVoltReading5 = (TextView)v.findViewById(R.id.all_input_volts5);
	       allVoltLabel5 = (TextView)v.findViewById(R.id.volt_label_5);
	       allVoltCh6 = (TextView)v.findViewById(R.id.volt_ch_6);
	       allVoltReading6 = (TextView)v.findViewById(R.id.all_input_volts6);
	       allVoltLabel6 = (TextView)v.findViewById(R.id.volt_label_6);
	       allVoltCh7 = (TextView)v.findViewById(R.id.volt_ch_7);
	       allVoltReading7 = (TextView)v.findViewById(R.id.all_input_volts7);
	       allVoltLabel7 = (TextView)v.findViewById(R.id.volt_label_7);
           break;
        /*case 5:
            //resId = R.layout.remote;
        	resId = R.layout.setup;
            break; */
        case 5:
            resId = R.layout.log;
            v = inflater.inflate(resId, null, false);
            logText = (TextView)v.findViewById(R.id.logtext);
            logText.setOnLongClickListener(
    				new View.OnLongClickListener(){
    					@Override
    					public boolean onLongClick(View arg0) {
    						String listText = logText.getText().toString();
    						//Log.v("LongClick: ", listText);
    						((AndroiDAQTCPMain) context).writeToFile(listText);
    						return false;
    					}
    				}
    		);
            logSV = (ScrollView)v.findViewById(R.id.scrollViewLog);
            logSV.setScrollbarFadingEnabled(false);
            refreshLog = (Button)v.findViewById(R.id.refreshlog);
            refreshLog.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                	((AndroiDAQTCPMain) context).setFromMenu(true);
                	((AndroiDAQTCPMain) context).sendMessage("07\r");
                }
            }); 
            openMenu = (Button)v.findViewById(R.id.open_menu);
            openMenu.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                	((AndroiDAQTCPMain) context).openMenu();
                }
            }); 
            break;
        case 6:
            resId = R.layout.adc;
            v = inflater.inflate(resId, null, false);
            adcSV = (ScrollView)v.findViewById(R.id.scrollViewADC);
            adcSV.setScrollbarFadingEnabled(false);
            samples = (EditText)v.findViewById(R.id.samples1);
            samples.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "4096")});
            samples.setSelectAllOnFocus(true);
            samples.setOnKeyListener(new OnKeyListener() {
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                       //Toast.makeText(context, samples.getText(), Toast.LENGTH_SHORT).show();
                       String theText = samples.getText().toString();
                       samples.clearFocus();
   						if (theText.matches("")) {
   							samples.setText("100");
   							samples.selectAll();
   						}
                       return false;
                  }
                return false;
                }
            });
            ratesList = (Spinner) v.findViewById(R.id.rates);
            ArrayAdapter<String> adap = new ArrayAdapter<String>(this.context, R.layout.spinner_item, new String[]{"100uSecs", 
            "500uSecs",  "1mSec", "10mSecs", "50mSecs",  "100mSecs", "500mSecs", "1-Sec"});
            adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            ratesList.setAdapter(adap);
            ratesList.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					itemText =  ratesList.getSelectedItem().toString();
					if (waveRate != null) waveRate.setText("Longpress to take 448 samples at: " + itemText);
				}
				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
            });
            readSamples = (Button)v.findViewById(R.id.readSamples);
            readSamples.setOnClickListener(
                    new View.OnClickListener()
                    {
                        public void onClick(View view)
                        {
                            String sampleNum = samples.getText().toString();
                        	Log.v("EditText: ", sampleNum);
                            int itemNum = ratesList.getSelectedItemPosition();
                            String[] values = {"10000", "2000", "1000", "100", "20", "10", "2", "1"};
                            String rateText = values[itemNum];
                            Log.v("Spinner: ", rateText);
                            int connected = ((AndroiDAQTCPMain)context).btState();
                        	if ( connected != 3) {
                                Toast.makeText(context, R.string.not_connected, Toast.LENGTH_SHORT).show();
                                sendOutputs = false;
                            } else {
                            	((AndroiDAQTCPMain) context).getADCSample(true, sampleNum, rateText);
                            }
                        }
                    });
            break;
        case 7:
            resId = R.layout.waveform;
            v = inflater.inflate(resId, null, false);
            waveRate = (TextView)v.findViewById(R.id.waveRate);
            waveRate.setText("Longpress to take 448 samples at: " +  ratesList.getSelectedItem().toString());
            mWaveform = (WaveFormView)v.findViewById(R.id.WaveformArea);
            mWaveform.setOnLongClickListener(
    				new View.OnLongClickListener(){
    					@Override
    					public boolean onLongClick(View arg0) {
    						String sampleNum = samples.getText().toString();
                        	Log.v("EditText: ", sampleNum);
                            int itemNum = ratesList.getSelectedItemPosition();
                            String[] values = {"10000", "2000", "1000", "100", "20", "10", "2", "1"};
                            String rateText = values[itemNum];
                            Log.v("Spinner: ", rateText);
    						Toast.makeText(context, "Getting Samples", Toast.LENGTH_SHORT).show();
    						((AndroiDAQTCPMain) context).getOscopeSample(true, rateText);
    						return false;
    					}
    				}
    		);

            sendOutputs = false;
            break;
        case 8:
            resId = R.layout.remote;
            v = inflater.inflate(resId, null, false);
            speed = (SeekBar)v.findViewById(R.id.seekBar1);
            speed.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    // TODO Auto-generated method stub
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    // TODO Auto-generated method stub
                }

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    // TODO Auto-generated method stub
                	speedPercent = progress;
                	out_freq0.setText(Integer.toString(speedPercent));
                	allFreqOut0.setText(Integer.toString(speedPercent));
                }
            });
            forward = (Button)v.findViewById(R.id.button1);
            forward.setOnTouchListener(new OnTouchListener() {
        	    @Override
        	    public boolean onTouch(View v, MotionEvent event) {
                	int connected = ((AndroiDAQTCPMain)context).btState();
                	if ( connected != 3) {
                        Toast.makeText(context, R.string.not_connected, Toast.LENGTH_SHORT).show();
                        sendOutputs = false;
                    } else {
                    	switch(event.getAction() & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_DOWN:
                        	if (!buttonDown) {
	                        	sendOutputs = true;
	                        	buttonDown = true;
	                        	allFreqOut0.setText(out_freq0.getText()); 
	                			allFreqOut1.setText(out_freq1.getText());  
	                			allFreqOut2.setText(out_freq2.getText());  
	                			allFreqOut3.setText(out_freq3.getText()); 
	                			allFreqOut4.setText(out_freq4.getText());  
	                			allFreqOut5.setText(out_freq5.getText()); 
	                			allFreqOut6.setText(out_freq6.getText());  
	                			allFreqOut7.setText(out_freq7.getText());  
	                			allFreqOut8.setText(out_freq8.getText());  
	                			allFreqOut9.setText(out_freq9.getText());  
	                			allFreqOut10.setText(out_freq10.getText()); 
	                			allFreqOut11.setText(out_freq11.getText());
	                			allFreqOut12.setText(out_freq12.getText());  
	                			allFreqOut13.setText(out_freq13.getText()); 
	                			allFreqOut14.setText(out_freq14.getText()); 
	                			allFreqOut15.setText(out_freq15.getText());
	                			allDutyOut0.setText(duty_freq0.getText());
	                			allDutyOut1.setText(duty_freq1.getText());  
	                			allDutyOut2.setText(duty_freq2.getText());  
	                			allDutyOut3.setText(duty_freq3.getText()); 
	                			allDutyOut4.setText(duty_freq4.getText());  
	                			allDutyOut5.setText(duty_freq5.getText()); 
	                			allDutyOut6.setText(duty_freq6.getText());  
	                			allDutyOut7.setText(duty_freq7.getText());  
	                			allDutyOut8.setText(duty_freq8.getText());  
	                			allDutyOut9.setText(duty_freq9.getText());  
	                			allDutyOut10.setText(duty_freq10.getText()); 
	                			allDutyOut11.setText(duty_freq11.getText());
	                			allDutyOut12.setText(duty_freq12.getText());  
	                			allDutyOut13.setText(duty_freq13.getText()); 
	                			allDutyOut14.setText(duty_freq14.getText()); 
	                			allDutyOut15.setText(duty_freq15.getText());
	                			out_hiLow1.setChecked(true);
	                			out_hiLow2.setChecked(true);
	                        	setProp();
                        	}
                          return true;
                        case MotionEvent.ACTION_UP:
                        	if (buttonDown) {
	                        	sendOutputs = true;
	                        	buttonDown = false;
	                			allFreqOut0.setText("0"); 
	                			allFreqOut1.setText("0");  
	                			allFreqOut2.setText("0");  
	                			allFreqOut3.setText("0"); 
	                			allFreqOut4.setText("0");  
	                			allFreqOut5.setText("0"); 
	                			allFreqOut6.setText("0");  
	                			allFreqOut7.setText("0");  
	                			allFreqOut8.setText("0");  
	                			allFreqOut9.setText("0");  
	                			allFreqOut10.setText("0"); 
	                			allFreqOut11.setText("0"); 
	                			allFreqOut12.setText("0");  
	                			allFreqOut13.setText("0");  
	                			allFreqOut14.setText("0"); 
	                			allFreqOut15.setText("0"); 
	                			allDutyOut0.setText("50"); 
	                			allDutyOut1.setText("50");  
	                			allDutyOut2.setText("50");  
	                			allDutyOut3.setText("50"); 
	                			allDutyOut4.setText("50");  
	                			allDutyOut5.setText("50"); 
	                			allDutyOut6.setText("50");  
	                			allDutyOut7.setText("50");  
	                			allDutyOut8.setText("50");  
	                			allDutyOut9.setText("50");  
	                			allDutyOut10.setText("50"); 
	                			allDutyOut11.setText("50"); 
	                			allDutyOut12.setText("50");  
	                			allDutyOut13.setText("50");  
	                			allDutyOut14.setText("50"); 
	                			allDutyOut15.setText("50"); 
	                        	setProp();
                        	}
                          return true;
                    	}                    	
                    }
					return true;
                }
            });
            reverse = (Button)v.findViewById(R.id.button5);
            reverse.setOnTouchListener(new OnTouchListener() {
        	    @Override
        	    public boolean onTouch(View v, MotionEvent event) {
                	int connected = ((AndroiDAQTCPMain)context).btState();
                	if ( connected != 3) {
                        Toast.makeText(context, R.string.not_connected, Toast.LENGTH_SHORT).show();
                        sendOutputs = false;
                    } else {
                    	switch(event.getAction() & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_DOWN:
                        	if (!buttonDown) {
	                        	sendOutputs = true;
	                        	buttonDown = true;
	                        	allFreqOut0.setText(out_freq0.getText()); 
	                			allFreqOut1.setText(out_freq1.getText());  
	                			allFreqOut2.setText(out_freq2.getText());  
	                			allFreqOut3.setText(out_freq3.getText()); 
	                			allFreqOut4.setText(out_freq4.getText());  
	                			allFreqOut5.setText(out_freq5.getText()); 
	                			allFreqOut6.setText(out_freq6.getText());  
	                			allFreqOut7.setText(out_freq7.getText());  
	                			allFreqOut8.setText(out_freq8.getText());  
	                			allFreqOut9.setText(out_freq9.getText());  
	                			allFreqOut10.setText(out_freq10.getText()); 
	                			allFreqOut11.setText(out_freq11.getText());
	                			allFreqOut12.setText(out_freq12.getText());  
	                			allFreqOut13.setText(out_freq13.getText()); 
	                			allFreqOut14.setText(out_freq14.getText()); 
	                			allFreqOut15.setText(out_freq15.getText());
	                			allDutyOut0.setText(duty_freq0.getText()); 
	                			allDutyOut1.setText(duty_freq1.getText());  
	                			allDutyOut2.setText(duty_freq2.getText());  
	                			allDutyOut3.setText(duty_freq3.getText()); 
	                			allDutyOut4.setText(duty_freq4.getText());  
	                			allDutyOut5.setText(duty_freq5.getText()); 
	                			allDutyOut6.setText(duty_freq6.getText());  
	                			allDutyOut7.setText(duty_freq7.getText());  
	                			allDutyOut8.setText(duty_freq8.getText());  
	                			allDutyOut9.setText(duty_freq9.getText());  
	                			allDutyOut10.setText(duty_freq10.getText()); 
	                			allDutyOut11.setText(duty_freq11.getText());
	                			allDutyOut12.setText(duty_freq12.getText());  
	                			allDutyOut13.setText(duty_freq13.getText()); 
	                			allDutyOut14.setText(duty_freq14.getText()); 
	                			allDutyOut15.setText(duty_freq15.getText());
	                			out_hiLow1.setChecked(false);
	                			out_hiLow2.setChecked(false);
	                        	setProp();
                        	}
                          return true;
                        case MotionEvent.ACTION_UP:
                        	if (buttonDown) {
	                        	sendOutputs = true;
	                        	buttonDown = false;
	                			allFreqOut0.setText("0"); 
	                			allFreqOut1.setText("0");  
	                			allFreqOut2.setText("0");  
	                			allFreqOut3.setText("0"); 
	                			allFreqOut4.setText("0");  
	                			allFreqOut5.setText("0"); 
	                			allFreqOut6.setText("0");  
	                			allFreqOut7.setText("0");  
	                			allFreqOut8.setText("0");  
	                			allFreqOut9.setText("0");  
	                			allFreqOut10.setText("0"); 
	                			allFreqOut11.setText("0"); 
	                			allFreqOut12.setText("0");  
	                			allFreqOut13.setText("0");  
	                			allFreqOut14.setText("0"); 
	                			allFreqOut15.setText("0"); 
	                			allDutyOut0.setText("50"); 
	                			allDutyOut1.setText("50");  
	                			allDutyOut2.setText("50");  
	                			allDutyOut3.setText("50"); 
	                			allDutyOut4.setText("50");  
	                			allDutyOut5.setText("50"); 
	                			allDutyOut6.setText("50");  
	                			allDutyOut7.setText("50");  
	                			allDutyOut8.setText("50");  
	                			allDutyOut9.setText("50");  
	                			allDutyOut10.setText("50"); 
	                			allDutyOut11.setText("50"); 
	                			allDutyOut12.setText("50");  
	                			allDutyOut13.setText("50");  
	                			allDutyOut14.setText("50"); 
	                			allDutyOut15.setText("50"); 
	                        	setProp();
                        	}
                          return true;
                    	}                    	
                    }
					return true;
                }
            });
            left = (Button)v.findViewById(R.id.button2);
            left.setOnTouchListener(new OnTouchListener() {
        	    @Override
        	    public boolean onTouch(View v, MotionEvent event) {
                	int connected = ((AndroiDAQTCPMain)context).btState();
                	if ( connected != 3) {
                        Toast.makeText(context, R.string.not_connected, Toast.LENGTH_SHORT).show();
                        sendOutputs = false;
                    } else {
                    	switch(event.getAction() & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_DOWN:
                        	if (!buttonDown) {
	                        	sendOutputs = true;
	                        	buttonDown = true;
	                        	allFreqOut0.setText(out_freq0.getText()); 
	                			allFreqOut1.setText(out_freq1.getText());  
	                			allFreqOut2.setText(out_freq2.getText());  
	                			allFreqOut3.setText(out_freq3.getText()); 
	                			allFreqOut4.setText(out_freq4.getText());  
	                			allFreqOut5.setText(out_freq5.getText()); 
	                			allFreqOut6.setText(out_freq6.getText());  
	                			allFreqOut7.setText(out_freq7.getText());  
	                			allFreqOut8.setText(out_freq8.getText());  
	                			allFreqOut9.setText(out_freq9.getText());  
	                			allFreqOut10.setText(out_freq10.getText()); 
	                			allFreqOut11.setText(out_freq11.getText());
	                			allFreqOut12.setText(out_freq12.getText());  
	                			allFreqOut13.setText(out_freq13.getText()); 
	                			allFreqOut14.setText(out_freq14.getText()); 
	                			allFreqOut15.setText(out_freq15.getText());
	                			allDutyOut0.setText(duty_freq0.getText()); 
	                			allDutyOut1.setText(duty_freq1.getText());  
	                			allDutyOut2.setText(duty_freq2.getText());  
	                			allDutyOut3.setText(duty_freq3.getText()); 
	                			allDutyOut4.setText(duty_freq4.getText());  
	                			allDutyOut5.setText(duty_freq5.getText()); 
	                			allDutyOut6.setText(duty_freq6.getText());  
	                			allDutyOut7.setText(duty_freq7.getText());  
	                			allDutyOut8.setText(duty_freq8.getText());  
	                			allDutyOut9.setText(duty_freq9.getText());  
	                			allDutyOut10.setText(duty_freq10.getText()); 
	                			allDutyOut11.setText(duty_freq11.getText());
	                			allDutyOut12.setText(duty_freq12.getText());  
	                			allDutyOut13.setText(duty_freq13.getText()); 
	                			allDutyOut14.setText(duty_freq14.getText()); 
	                			allDutyOut15.setText(duty_freq15.getText());
	                			out_hiLow1.setChecked(false);
	                			out_hiLow2.setChecked(true);
	                        	setProp();
                        	}
                          return true;
                        case MotionEvent.ACTION_UP:
                        	if (buttonDown) {
	                        	sendOutputs = true;
	                        	buttonDown = false;
	                			allFreqOut0.setText("0"); 
	                			allFreqOut1.setText("0");  
	                			allFreqOut2.setText("0");  
	                			allFreqOut3.setText("0"); 
	                			allFreqOut4.setText("0");  
	                			allFreqOut5.setText("0"); 
	                			allFreqOut6.setText("0");  
	                			allFreqOut7.setText("0");  
	                			allFreqOut8.setText("0");  
	                			allFreqOut9.setText("0");  
	                			allFreqOut10.setText("0"); 
	                			allFreqOut11.setText("0"); 
	                			allFreqOut12.setText("0");  
	                			allFreqOut13.setText("0");  
	                			allFreqOut14.setText("0"); 
	                			allFreqOut15.setText("0"); 
	                			allDutyOut0.setText("50"); 
	                			allDutyOut1.setText("50");  
	                			allDutyOut2.setText("50");  
	                			allDutyOut3.setText("50"); 
	                			allDutyOut4.setText("50");  
	                			allDutyOut5.setText("50"); 
	                			allDutyOut6.setText("50");  
	                			allDutyOut7.setText("50");  
	                			allDutyOut8.setText("50");  
	                			allDutyOut9.setText("50");  
	                			allDutyOut10.setText("50"); 
	                			allDutyOut11.setText("50"); 
	                			allDutyOut12.setText("50");  
	                			allDutyOut13.setText("50");  
	                			allDutyOut14.setText("50"); 
	                			allDutyOut15.setText("50"); 
	                        	setProp();
                        	}
                          return true;
                    	}                    	
                    }
					return true;
                }
            });
            right = (Button)v.findViewById(R.id.button4);
            right.setOnTouchListener(new OnTouchListener() {
        	    @Override
        	    public boolean onTouch(View v, MotionEvent event) {
                	int connected = ((AndroiDAQTCPMain)context).btState();
                	if ( connected != 3) {
                        Toast.makeText(context, R.string.not_connected, Toast.LENGTH_SHORT).show();
                        sendOutputs = false;
                    } else {
                    	switch(event.getAction() & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_DOWN:
                        	if (!buttonDown) {
	                        	sendOutputs = true;
	                        	buttonDown = true;
	                        	allFreqOut0.setText(out_freq0.getText()); 
	                			allFreqOut1.setText(out_freq1.getText());  
	                			allFreqOut2.setText(out_freq2.getText());  
	                			allFreqOut3.setText(out_freq3.getText()); 
	                			allFreqOut4.setText(out_freq4.getText());  
	                			allFreqOut5.setText(out_freq5.getText()); 
	                			allFreqOut6.setText(out_freq6.getText());  
	                			allFreqOut7.setText(out_freq7.getText());  
	                			allFreqOut8.setText(out_freq8.getText());  
	                			allFreqOut9.setText(out_freq9.getText());  
	                			allFreqOut10.setText(out_freq10.getText()); 
	                			allFreqOut11.setText(out_freq11.getText());
	                			allFreqOut12.setText(out_freq12.getText());  
	                			allFreqOut13.setText(out_freq13.getText()); 
	                			allFreqOut14.setText(out_freq14.getText()); 
	                			allFreqOut15.setText(out_freq15.getText());
	                			allDutyOut0.setText(duty_freq0.getText()); 
	                			allDutyOut1.setText(duty_freq1.getText());  
	                			allDutyOut2.setText(duty_freq2.getText());  
	                			allDutyOut3.setText(duty_freq3.getText()); 
	                			allDutyOut4.setText(duty_freq4.getText());  
	                			allDutyOut5.setText(duty_freq5.getText()); 
	                			allDutyOut6.setText(duty_freq6.getText());  
	                			allDutyOut7.setText(duty_freq7.getText());  
	                			allDutyOut8.setText(duty_freq8.getText());  
	                			allDutyOut9.setText(duty_freq9.getText());  
	                			allDutyOut10.setText(duty_freq10.getText()); 
	                			allDutyOut11.setText(duty_freq11.getText());
	                			allDutyOut12.setText(duty_freq12.getText());  
	                			allDutyOut13.setText(duty_freq13.getText()); 
	                			allDutyOut14.setText(duty_freq14.getText()); 
	                			allDutyOut15.setText(duty_freq15.getText());
	                			out_hiLow1.setChecked(true);
	                			out_hiLow2.setChecked(false);
	                        	setProp();
                        	}
                          return true;
                        case MotionEvent.ACTION_UP:
                        	if (buttonDown) {
	                        	sendOutputs = true;
	                        	buttonDown = false;
	                			allFreqOut0.setText("0"); 
	                			allFreqOut1.setText("0");  
	                			allFreqOut2.setText("0");  
	                			allFreqOut3.setText("0"); 
	                			allFreqOut4.setText("0");  
	                			allFreqOut5.setText("0"); 
	                			allFreqOut6.setText("0");  
	                			allFreqOut7.setText("0");  
	                			allFreqOut8.setText("0");  
	                			allFreqOut9.setText("0");  
	                			allFreqOut10.setText("0"); 
	                			allFreqOut11.setText("0"); 
	                			allFreqOut12.setText("0");  
	                			allFreqOut13.setText("0");  
	                			allFreqOut14.setText("0"); 
	                			allFreqOut15.setText("0"); 
	                			allDutyOut0.setText("50"); 
	                			allDutyOut1.setText("50");  
	                			allDutyOut2.setText("50");  
	                			allDutyOut3.setText("50"); 
	                			allDutyOut4.setText("50");  
	                			allDutyOut5.setText("50"); 
	                			allDutyOut6.setText("50");  
	                			allDutyOut7.setText("50");  
	                			allDutyOut8.setText("50");  
	                			allDutyOut9.setText("50");  
	                			allDutyOut10.setText("50"); 
	                			allDutyOut11.setText("50"); 
	                			allDutyOut12.setText("50");  
	                			allDutyOut13.setText("50");  
	                			allDutyOut14.setText("50"); 
	                			allDutyOut15.setText("50"); 
	                        	setProp();
                        	}
                          return true;
                    	}                    	
                    }
					return true;
                }
            });
            break;
        case 9:
            resId = R.layout.quickset;
            v = inflater.inflate(resId, null, false);
            resetValues = (Button)v.findViewById(R.id.reset1);
            resetValues.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                	//TODO set all values to default
                	boolean[] areInputs = new boolean[16];
                	Arrays.fill(areInputs, Boolean.FALSE);
                	boolean[] areDigital = new boolean[16];
                    Arrays.fill(areDigital, Boolean.TRUE);
                    boolean[] areOutputs = new boolean[16];
                    Arrays.fill(areOutputs, Boolean.FALSE);
                    String[] freqs = new String[16];
                    String[] duties = new String[16];
                    Arrays.fill(freqs, "0");
                	Bundle myBundle = new Bundle();
            		myBundle.putBooleanArray("isInput", areInputs);
            		myBundle.putBooleanArray("isDig", areDigital);
            		myBundle.putBooleanArray("outputState", areOutputs);
            		myBundle.putStringArray("desiredFreqs", freqs);
            		myBundle.putStringArray("desiredDutys", duties);
            		setUIStates(myBundle);
            		notifyDataSetChanged();
                }
            }); 
            break;
        }
        //View view = inflater.inflate(resId, null);
        ((ViewPager) collection).addView(v, 0);
        return v;
    }
    // Set text in log TextView and scroll to bottom
    public void setText(String text) {
    	//boolean hasTab = text.contains("\u0009");
    	int temp = logText.getLineCount();
    	//Log.e("Test", "logText is: " + temp);
    	if (temp == 1) {
    		logText.setText("");
    	}
    	logText.append(text);
     }
    // Set text in Volts and All-volts entries and scroll to bottom
    public void setVoltText(String text) { 
    	//boolean hasTab = text.contains("\u0009");
    	String voltText = text;
    	Log.e("Test", "voltText is: " + voltText);
    	String[] voltages = voltText.split("\\r");
    	int numOfArrays = voltages.length;
    	//Log.e("Test", "numOfArrays volts is: " + numOfArrays);
    	if (numOfArrays == 9) {
    		volts1.setText(voltages[0]);
    		allVoltReading0.setText(voltages[0]);
    		volts2.setText(voltages[1]);
    		allVoltReading1.setText(voltages[1]);
    		volts3.setText(voltages[2]);
    		allVoltReading2.setText(voltages[2]);
    		volts4.setText(voltages[3]);
    		allVoltReading3.setText(voltages[3]);
    		volts5.setText(voltages[4]);
    		allVoltReading4.setText(voltages[4]);
    		volts6.setText(voltages[5]);
    		allVoltReading5.setText(voltages[5]);
    		volts7.setText(voltages[6]);
    		allVoltReading6.setText(voltages[6]);
    		volts8.setText(voltages[7]);
    		allVoltReading7.setText(voltages[7]);
    	} 
    	if (runAll) {
    		((AndroiDAQTCPMain) context).getAll(false);
    	} else if (!runContVolts) {
    		((AndroiDAQTCPMain) context).getVolts(false);
    	}
     }
    // Set text in Inputs and All-inputs entries and scroll to bottom
    public void setInputsText(String text) { 
    	//boolean hasTab = text.contains("\u0009");
    	String inputText = text;
    	Log.e("Test", "inputText is: " + inputText);
    	String[] inputReadings = inputText.split("\\r");
    	int numOfArrays = inputReadings.length;
    	int numInputsSet = chsAreInputs.size();
    	Log.e("Test", "numOfArrays inputs is: " + numOfArrays);
    	Log.e("Test", "numOf inputs is: " + numInputsSet);
    	Log.e("Test", "inputs are: " + chsAreInputs);
    	int index = 0;
    	if (numOfArrays == numInputsSet + 1 || numOfArrays == numInputsSet) { //TODO this needs to change for variable outputs
    		if (chsAreInputs.contains("0")) {
	    		if (Integer.valueOf(inputReadings[index]) == 1) {
	    			hiLow0.setChecked(true);
	    			allDigIn0.setChecked(true);
	    		} else if (Integer.valueOf(inputReadings[index]) == 0) {
	    			hiLow0.setChecked(false);
	    			allDigIn0.setChecked(false);
	    		} else {
	    			freq0.setText(inputReadings[index]);
	    			allFreqIn0.setText(inputReadings[index]);
	    		}
	    		index++;
    		}
    		if (chsAreInputs.contains("1")) {
	    		if (Integer.valueOf(inputReadings[index]) == 1) {
	    			hiLow1.setChecked(true);
	    			allDigIn1.setChecked(true);
	    		} else if (Integer.valueOf(inputReadings[index]) == 0) {
	    			hiLow1.setChecked(false);
	    			allDigIn1.setChecked(false);
	    		} else {
	    			freq1.setText(inputReadings[index]);
	    			allFreqIn1.setText(inputReadings[index]);
	    		}
	    		index++;
    		}
    		if (chsAreInputs.contains("2")) {
	    		if (Integer.valueOf(inputReadings[index]) == 1) {
	    			hiLow2.setChecked(true);
	    			allDigIn2.setChecked(true);
	    		} else if (Integer.valueOf(inputReadings[index]) == 0) {
	    			hiLow2.setChecked(false);
	    			allDigIn2.setChecked(false);
	    		} else {
	    			freq2.setText(inputReadings[index]);
	    			allFreqIn2.setText(inputReadings[index]);
	    		}
	    		index++;
    		}
    		if (chsAreInputs.contains("3")) {
    	   		if (Integer.valueOf(inputReadings[index]) == 1) {
	    			hiLow3.setChecked(true);
	    			allDigIn3.setChecked(true);
	    		} else if (Integer.valueOf(inputReadings[index]) == 0) {
	    			hiLow3.setChecked(false);
	    			allDigIn3.setChecked(false);
	    		} else {
	    			freq3.setText(inputReadings[index]);
	    			allFreqIn3.setText(inputReadings[index]);
	    		}
	    		index++;
    		}
    		if (chsAreInputs.contains("4")) {
	    		if (Integer.valueOf(inputReadings[index]) == 1) {
	    			hiLow4.setChecked(true);
	    			allDigIn4.setChecked(true);
	    		} else if (Integer.valueOf(inputReadings[index]) == 0) {
	    			hiLow4.setChecked(false);
	    			allDigIn4.setChecked(false);
	    		} else {
	    			freq4.setText(inputReadings[index]);
	    			allFreqIn4.setText(inputReadings[index]);
	    		}
	    		index++;
    		}
    		if (chsAreInputs.contains("5")) {
	    		if (Integer.valueOf(inputReadings[index]) == 1) {
	    			hiLow5.setChecked(true);
	    			allDigIn5.setChecked(true);
	    		} else if (Integer.valueOf(inputReadings[index]) == 0) {
	    			hiLow5.setChecked(false);
	    			allDigIn5.setChecked(false);
	    		} else {
	    			freq5.setText(inputReadings[index]);
	    			allFreqIn5.setText(inputReadings[index]);
	    		}
	    		index++;
    		}
    		if (chsAreInputs.contains("6")) {
	    		if (Integer.valueOf(inputReadings[index]) == 1) {
	    			hiLow6.setChecked(true);
	    			allDigIn6.setChecked(true);
	    		} else if (Integer.valueOf(inputReadings[index]) == 0) {
	    			hiLow6.setChecked(false);
	    			allDigIn6.setChecked(false);
	    		} else {
	    			freq6.setText(inputReadings[index]);
	    			allFreqIn6.setText(inputReadings[index]);
	    		}
	    		index++;
    		}
    		if (chsAreInputs.contains("7")) {
	    		if (Integer.valueOf(inputReadings[index]) == 1) {
	    			hiLow7.setChecked(true);
	    			allDigIn7.setChecked(true);
	    		} else if (Integer.valueOf(inputReadings[index]) == 0) {
	    			hiLow7.setChecked(false);
	    			allDigIn7.setChecked(false);
	    		} else {
	    			freq7.setText(inputReadings[index]);
	    			allFreqIn7.setText(inputReadings[index]);
	    		}
	    		index++;
    		}
    		if (chsAreInputs.contains("8")) {
	    		if (Integer.valueOf(inputReadings[index]) == 1) {
	    			hiLow8.setChecked(true);
	    			allDigIn8.setChecked(true);
	    		} else if (Integer.valueOf(inputReadings[index]) == 0) {
	    			hiLow8.setChecked(false);
	    			allDigIn8.setChecked(false);
	    		} else {
	    			freq8.setText(inputReadings[index]);
	    			allFreqIn8.setText(inputReadings[index]);
	    		}
	    		index++;
    		}
    		if (chsAreInputs.contains("9")) {
	    		if (Integer.valueOf(inputReadings[index]) == 1) {
	    			hiLow9.setChecked(true);
	    			allDigIn9.setChecked(true);
	    		} else if (Integer.valueOf(inputReadings[index]) == 0) {
	    			hiLow9.setChecked(false);
	    			allDigIn9.setChecked(false);
	    		} else {
	    			freq9.setText(inputReadings[index]);
	    			allFreqIn9.setText(inputReadings[index]);
	    		}
	    		index++;
    		}
    		if (chsAreInputs.contains("10")) {
	    		if (Integer.valueOf(inputReadings[index]) == 1) {
	    			hiLow10.setChecked(true);
	    			allDigIn10.setChecked(true);
	    		} else if (Integer.valueOf(inputReadings[index]) == 0) {
	    			hiLow10.setChecked(false);
	    			allDigIn10.setChecked(false);
	    		} else {
	    			freq10.setText(inputReadings[index]);
	    			allFreqIn10.setText(inputReadings[index]);
	    		}
	    		index++;
    		}
    		if (chsAreInputs.contains("11")) {
	    		if (Integer.valueOf(inputReadings[index]) == 1) {
	    			hiLow11.setChecked(true);
	    			allDigIn11.setChecked(false);
	    		} else if (Integer.valueOf(inputReadings[index]) == 0) {
	    			hiLow11.setChecked(false);
	    			allDigIn11.setChecked(false);
	    		} else {
	    			freq11.setText(inputReadings[index]);
	    			allFreqIn11.setText(inputReadings[index]);
	    		}
	    		index++;
    		}
    		if (chsAreInputs.contains("12")) {
	    		if (Integer.valueOf(inputReadings[index]) == 1) {
	    			hiLow12.setChecked(true);
	    			allDigIn12.setChecked(true);
	    		} else if (Integer.valueOf(inputReadings[index]) == 0) {
	    			hiLow12.setChecked(false);
	    			allDigIn12.setChecked(false);
	    		} else {
	    			freq12.setText(inputReadings[index]);
	    			allFreqIn12.setText(inputReadings[index]);
	    		}
	    		index++;
    		}
    		if (chsAreInputs.contains("13")) {
	    		if (Integer.valueOf(inputReadings[index]) == 1) {
	    			hiLow13.setChecked(true);
	    			allDigIn13.setChecked(true);
	    		} else if (Integer.valueOf(inputReadings[index]) == 0) {
	    			hiLow13.setChecked(false);
	    			allDigIn13.setChecked(false);
	    		} else {
	    			freq13.setText(inputReadings[index]);
	    			allFreqIn13.setText(inputReadings[index]);
	    		}
	    		index++;
    		}
    		if (chsAreInputs.contains("14")) {
	    		if (Integer.valueOf(inputReadings[index]) == 1) {
	    			hiLow14.setChecked(true);
	    			allDigIn14.setChecked(true);
	    		} else if (Integer.valueOf(inputReadings[index]) == 0) {
	    			hiLow14.setChecked(false);
	    			allDigIn14.setChecked(false);
	    		} else {
	    			freq14.setText(inputReadings[index]);
	    			allFreqIn14.setText(inputReadings[index]);
	    		}
	    		index++;
    		}
    		if (chsAreInputs.contains("15")) {
	    		if (Integer.valueOf(inputReadings[index]) == 1) {
	    			hiLow15.setChecked(true);
	    			allDigIn15.setChecked(true);
	    		} else if (Integer.valueOf(inputReadings[index]) == 0) {
	    			hiLow15.setChecked(false);
	    			allDigIn15.setChecked(false);
	    		} else {
	    			freq15.setText(inputReadings[index]);
	    			allFreqIn15.setText(inputReadings[index]);
	    		}
    		}
    		
    	}
    	if (runAll) {
     		((AndroiDAQTCPMain) context).getInputs(false);
    		runAll = false;
    	} else if (!runContInputs) {
    		((AndroiDAQTCPMain) context).getInputs(false);
    	}
     }
    // get input channel list
    public ArrayList<String> getInputChannels() {
    	boolean[] isInput = {
    			isOutputCh0, 
    			isOutputCh1, 
    			isOutputCh2, 
    			isOutputCh3, 
    			isOutputCh4,
    			isOutputCh5, 
    			isOutputCh6, 
    			isOutputCh7, 
    			isOutputCh8,
    			isOutputCh9, 
    			isOutputCh10, 
    			isOutputCh11, 
    			isOutputCh12,
    			isOutputCh13, 
    			isOutputCh14, 
    			isOutputCh15};

    	ArrayList<String> inputChs = new ArrayList<String>();
    	int index = isInput.length;
    	for (int i = 0; i < index; i++) { 
    		if (!isInput[i]) {
    			inputChs.add(String.valueOf(i));
    		}
    	}
		return inputChs;    	
    }
    // which input channels are digital
    public ArrayList<String> getPulsedInputs(ArrayList<String> chsAreInputs) {
    	 //Log.e("Test", "isDigCh0 @ output is: " + isDigCh0);
    	boolean[] isDigital = {
    			isDigCh0, 
    			isDigCh1, 
    			isDigCh2, 
    			isDigCh3, 
    			isDigCh4,
    			isDigCh5, 
    			isDigCh6, 
    			isDigCh7, 
    			isDigCh8,
    			isDigCh9, 
    			isDigCh10, 
    			isDigCh11, 
    			isDigCh12,
    			isDigCh13, 
    			isDigCh14, 
    			isDigCh15};  	
    	// place check box value per output channel if digital
    	ArrayList<String> pulsedInputs = new ArrayList<String>(); 
    	int index1 = chsAreInputs.size(); // for each channel that is an output
    	for (int i = 0; i < index1; i++) {
    		int chNumber = Integer.valueOf(chsAreInputs.get(i));
    		//Log.e("Test", "Channel is: " + chNumber);
    		//Log.e("Test", "Channel value is: " + isDigital[chNumber]);
    		if (isDigital[chNumber] == false) {
    			pulsedInputs.add(String.valueOf(chNumber));
    		}
    	}
    	return pulsedInputs;
    }
    // get output channel list
    public ArrayList<String> getOutputChannels() {
    	boolean[] isOutput = {
    			isOutputCh0, 
    			isOutputCh1, 
    			isOutputCh2, 
    			isOutputCh3, 
    			isOutputCh4,
    			isOutputCh5, 
    			isOutputCh6, 
    			isOutputCh7, 
    			isOutputCh8,
    			isOutputCh9, 
    			isOutputCh10, 
    			isOutputCh11, 
    			isOutputCh12,
    			isOutputCh13, 
    			isOutputCh14, 
    			isOutputCh15};

    	ArrayList<String> outputChs = new ArrayList<String>();
    	int index = isOutput.length;
    	for (int i = 0; i < index; i++) { 
    		if (isOutput[i]) {
    			outputChs.add(String.valueOf(i));
    		}
    	}
		return outputChs;    	
    }
    // which output channels are digital
    public ArrayList<String> getDigitalOutputs(ArrayList<String> chsAreOutputs) {
    	boolean[] isDigital = {
    			isDigCh0, 
    			isDigCh1, 
    			isDigCh2, 
    			isDigCh3, 
    			isDigCh4,
    			isDigCh5, 
    			isDigCh6, 
    			isDigCh7, 
    			isDigCh8,
    			isDigCh9, 
    			isDigCh10, 
    			isDigCh11, 
    			isDigCh12,
    			isDigCh13, 
    			isDigCh14, 
    			isDigCh15};  	
    	// place check box value per output channel if digital
    	ArrayList<String> outputChsDigital = new ArrayList<String>(); 
    	int index1 = chsAreOutputs.size(); // for each channel that is an output
    	for (int i = 0; i < index1; i++) {
    		int chNumber = Integer.valueOf(chsAreOutputs.get(i));
    		//Log.e("Test", "Channel is: " + chNumber);
    		//Log.e("Test", "Channel value is: " + isDigital[chNumber]);
    		if (isDigital[chNumber] == true) {
    			outputChsDigital.add(String.valueOf(chNumber));
    		}
    	}
    	return outputChsDigital;
    }
 // get digital states for each digital output
    public ArrayList<String> getDigitalOutputState(ArrayList<String> isOutputDigital) { 
    	boolean[] outputState = {
    			out_hiLow0.isChecked(), 
    			out_hiLow1.isChecked(), 
    			out_hiLow2.isChecked(), 
    			out_hiLow3.isChecked(), 
    			out_hiLow4.isChecked(), 
    			out_hiLow5.isChecked(), 
    			out_hiLow6.isChecked(), 
    			out_hiLow7.isChecked(),  
    			out_hiLow8.isChecked(), 
    			out_hiLow9.isChecked(),  
    			out_hiLow10.isChecked(),  
    			out_hiLow11.isChecked(), 
    			out_hiLow12.isChecked(), 
    			out_hiLow13.isChecked(),  
    			out_hiLow14.isChecked(), 
    			out_hiLow15.isChecked()};
    	// place check box value per output channel if digital
    	ArrayList<String> outputStateChs = new ArrayList<String>(); 
    	int index1 = isOutputDigital.size();
    	for (int i = 0; i < index1; i++) {
    		int chNumber = Integer.valueOf(isOutputDigital.get(i));
    		//Log.e("Test", "Channel is: " + chNumber);
    		//Log.e("Test", "outputStateChs is: " + outputState[chNumber]);
    		outputStateChs.add(String.valueOf(outputState[chNumber]));
    			
    	}
    	return outputStateChs;
    }
    
    // which output channels are pulsed
    public ArrayList<String> getPulsedOutputs(ArrayList<String> chsAreOutputs) {
    	boolean[] isDigital = {
    			isDigCh0, 
    			isDigCh1, 
    			isDigCh2, 
    			isDigCh3, 
    			isDigCh4,
    			isDigCh5, 
    			isDigCh6, 
    			isDigCh7, 
    			isDigCh8,
    			isDigCh9, 
    			isDigCh10, 
    			isDigCh11, 
    			isDigCh12,
    			isDigCh13, 
    			isDigCh14, 
    			isDigCh15};  	
    	// place check box value per output channel if digital
    	ArrayList<String> outputChsPulsed = new ArrayList<String>(); 
    	int index1 = chsAreOutputs.size(); // for each channel that is an output
    	for (int i = 0; i < index1; i++) {
    		int chNumber = Integer.valueOf(chsAreOutputs.get(i));
    		//Log.e("Test", "Channel is: " + chNumber);
    		//Log.e("Test", "Channel value is: " + isDigital[chNumber]);
    		if (isDigital[chNumber] == false) {
    			outputChsPulsed.add(String.valueOf(chNumber));
    		}
    	}
    	return outputChsPulsed;
    }
    
    // get desired frequencies for each pulse output
    public ArrayList<String> getDesiredFreqs(ArrayList<String> isOutputPulsed) {
    	String[] desiredFreq = {
    			allFreqOut0.getText().toString(), 
    			allFreqOut1.getText().toString(), 
    			allFreqOut2.getText().toString(), 
    			allFreqOut3.getText().toString(), 
    			allFreqOut4.getText().toString(), 
    			allFreqOut5.getText().toString(), 
    			allFreqOut6.getText().toString(), 
    			allFreqOut7.getText().toString(), 
    			allFreqOut8.getText().toString(), 
    			allFreqOut9.getText().toString(), 
    			allFreqOut10.getText().toString(), 
    			allFreqOut11.getText().toString(), 
    			allFreqOut12.getText().toString(), 
    			allFreqOut13.getText().toString(), 
    			allFreqOut14.getText().toString(), 
    			allFreqOut15.getText().toString(), };
    	
    	ArrayList<String> freqChs = new ArrayList<String>();
    	int index = isOutputPulsed.size();
    	for (int i = 0; i < index; i++) {
    		int chNumber = Integer.valueOf(isOutputPulsed.get(i));
    		//Log.e("Test", "Channel is: " + chNumber);
    		//Log.e("Test", "outputStateChs is: " + desiredFreq[chNumber]);
    		freqChs.add(String.valueOf(desiredFreq[chNumber]));
    			
    	}
    	return freqChs;
    }
    public ArrayList<String> getDesiredDuty(ArrayList<String> isOutputPulsed) {
    	String[] desiredDutys = {
    			allDutyOut0.getText().toString(), 
    			allDutyOut1.getText().toString(), 
    			allDutyOut2.getText().toString(), 
    			allDutyOut3.getText().toString(), 
    			allDutyOut4.getText().toString(), 
    			allDutyOut5.getText().toString(), 
    			allDutyOut6.getText().toString(), 
    			allDutyOut7.getText().toString(), 
    			allDutyOut8.getText().toString(), 
    			allDutyOut9.getText().toString(), 
    			allDutyOut10.getText().toString(), 
    			allDutyOut11.getText().toString(), 
    			allDutyOut12.getText().toString(), 
    			allDutyOut13.getText().toString(), 
    			allDutyOut14.getText().toString(), 
    			allDutyOut15.getText().toString(), };
    	
    	ArrayList<String> dutyChs = new ArrayList<String>();
    	int index = isOutputPulsed.size();
    	for (int i = 0; i < index; i++) {
    		int chNumber = Integer.valueOf(isOutputPulsed.get(i));
    		//Log.e("Test", "Channel is: " + chNumber);
    		//Log.e("Test", "outputStateChs is: " + desiredFreq[chNumber]);
    		dutyChs.add(String.valueOf(desiredDutys[chNumber]));
    			
    	}
    	return dutyChs;
    }
    // get EditText values from Input screen and set value on EditText on All screen
	private void getInputString()	{
		allFreqOut0.setText(out_freq0.getText().toString());
		allFreqOut1.setText(out_freq1.getText().toString());
		allFreqOut2.setText(out_freq2.getText().toString());
		allFreqOut3.setText(out_freq3.getText().toString());
		allFreqOut4.setText(out_freq4.getText().toString());
		allFreqOut5.setText(out_freq5.getText().toString());
		allFreqOut6.setText(out_freq6.getText().toString());
		allFreqOut7.setText(out_freq7.getText().toString());
		allFreqOut8.setText(out_freq8.getText().toString());
		allFreqOut9.setText(out_freq9.getText().toString());
		allFreqOut10.setText(out_freq10.getText().toString());
		allFreqOut11.setText(out_freq11.getText().toString());
		allFreqOut12.setText(out_freq12.getText().toString());
		allFreqOut13.setText(out_freq13.getText().toString());
		allFreqOut14.setText(out_freq14.getText().toString());
		allFreqOut15.setText(out_freq15.getText().toString());

		imm.hideSoftInputFromWindow(out_freq0.getWindowToken(), 0);
	}
	private void getInputStringDuty()	{
		allDutyOut0.setText(duty_freq0.getText().toString());
		allDutyOut1.setText(duty_freq1.getText().toString());
		allDutyOut2.setText(duty_freq2.getText().toString());
		allDutyOut3.setText(duty_freq3.getText().toString());
		allDutyOut4.setText(duty_freq4.getText().toString());
		allDutyOut5.setText(duty_freq5.getText().toString());
		allDutyOut6.setText(duty_freq6.getText().toString());
		allDutyOut7.setText(duty_freq7.getText().toString());
		allDutyOut8.setText(duty_freq8.getText().toString());
		allDutyOut9.setText(duty_freq9.getText().toString());
		allDutyOut10.setText(duty_freq10.getText().toString());
		allDutyOut11.setText(duty_freq11.getText().toString());
		allDutyOut12.setText(duty_freq12.getText().toString());
		allDutyOut13.setText(duty_freq13.getText().toString());
		allDutyOut14.setText(duty_freq14.getText().toString());
		allDutyOut15.setText(duty_freq15.getText().toString());

		imm.hideSoftInputFromWindow(out_freq0.getWindowToken(), 0);
	}
	
	// get EditText values from All screen and set values on EditText on Input screen
	private void getAllInputString()	{
		out_freq0.setText(allFreqOut0.getText().toString());
		out_freq1.setText(allFreqOut1.getText().toString());
		out_freq2.setText(allFreqOut2.getText().toString());
		out_freq3.setText(allFreqOut3.getText().toString());
		out_freq4.setText(allFreqOut4.getText().toString());
		out_freq5.setText(allFreqOut5.getText().toString());
		out_freq6.setText(allFreqOut6.getText().toString());
		out_freq7.setText(allFreqOut7.getText().toString());
		out_freq8.setText(allFreqOut8.getText().toString());
		out_freq9.setText(allFreqOut9.getText().toString());
		out_freq10.setText(allFreqOut10.getText().toString());
		out_freq11.setText(allFreqOut11.getText().toString());
		out_freq12.setText(allFreqOut12.getText().toString());
		out_freq13.setText(allFreqOut13.getText().toString());
		out_freq14.setText(allFreqOut14.getText().toString());
		out_freq15.setText(allFreqOut15.getText().toString());
		duty_freq0.setText(allDutyOut0.getText().toString());
		duty_freq1.setText(allDutyOut1.getText().toString());
		duty_freq2.setText(allDutyOut2.getText().toString());
		duty_freq3.setText(allDutyOut3.getText().toString());
		duty_freq4.setText(allDutyOut4.getText().toString());
		duty_freq5.setText(allDutyOut5.getText().toString());
		duty_freq6.setText(allDutyOut6.getText().toString());
		duty_freq7.setText(allDutyOut7.getText().toString());
		duty_freq8.setText(allDutyOut8.getText().toString());
		duty_freq9.setText(allDutyOut9.getText().toString());
		duty_freq10.setText(allDutyOut10.getText().toString());
		duty_freq11.setText(allDutyOut11.getText().toString());
		duty_freq12.setText(allDutyOut12.getText().toString());
		duty_freq13.setText(allDutyOut13.getText().toString());
		duty_freq14.setText(allDutyOut14.getText().toString());
		duty_freq15.setText(allDutyOut15.getText().toString());

		imm.hideSoftInputFromWindow(allFreqOut0.getWindowToken(), 0);
	}
	public void setProp() {

		//Below is where the code for setting the inputs/outputs, states etc. and get readings from inputs.
    	//((AndroiDAQTCPMain) context).setPage(6); // this statement is used for development convenience
		chsAreInputs = getInputChannels(); // Inputs are read
    	ArrayList<String> isInputPulsed = getPulsedInputs(chsAreInputs);// which inputs are pulse reads
    	ArrayList<String> chsAreOutputs = getOutputChannels(); // Outputs can be digital or frequency
    	ArrayList<String> isOutputDigital = getDigitalOutputs(chsAreOutputs); // which output channels are digital
    	ArrayList<String> digitalOutState = getDigitalOutputState(isOutputDigital);// get output desired state
    	ArrayList<String> isOutputPulsed = getPulsedOutputs(chsAreOutputs); // which output channels are pulsed
    	ArrayList<String> desiredFreq = getDesiredFreqs(isOutputPulsed); // for channels not digital, what is the desired frequency
    	ArrayList<String> desiredDuty = getDesiredDuty(isOutputPulsed); // for channels not digital, what is the desired duty
    	//ArrayList<String> voltChsRead = getVoltageChannel(); // Get voltage channels read
    	/*setText("\n" + "Inputs are: " + chsAreInputs 
    			+ "\n" + "Input Pins that are pulsed are: " + isInputPulsed
    			+ "\n" + "Outputs Pins are: " + chsAreOutputs 
    			+ "\n" + "Outputs that are Digital: " + isOutputDigital
    			+  "\n" + "Digital output states are: " + digitalOutState
    			+ "\n" + "Pulsed output pins are: " + isOutputPulsed
    			+ "\n" + "Desired output frequencies are: " + desiredFreq 
    			+ "\n" + "Voltage Channels Read are: " + voltChsRead  + "\n"); */
    	
    	((AndroiDAQTCPMain) context).sendMessage("00\r"); // Send to AndroidDAQ menu command and Array(s) of information. 

    	String[] temp = new String[16];
    	Arrays.fill(temp, "NS"); // NS = Not Set
    	ArrayList<String> SendToProp = new ArrayList<String>(Arrays.asList(temp));
    	
    	//set input channels
    	int x0 = chsAreInputs.size();
    	// for each channel in chsAreInput, put zero in SendToProp channel location
    	for (int i = 0; i < x0; i++) { 
    		String channel = chsAreInputs.get(i);
    		SendToProp.set(Integer.valueOf(channel), "0");
    	}
    	// set input channels that are pulsed
    	int x1 = isInputPulsed.size();
    	for (int i = 0; i < x1; i++) { 
    		String channel = isInputPulsed.get(i);
    		SendToProp.set(Integer.valueOf(channel), "1");
    	}
    	// set output channels that are pulsed
    	int x2 = isOutputPulsed.size();
    	//Log.e("test", "isOutputPulsed size is:" + x2);
    	for (int i = 0; i < x2; i++) { 
    		String channel = isOutputPulsed.get(i);
    		String freq = desiredFreq.get(i);
    		String duty = desiredDuty.get(i);
    		SendToProp.set(Integer.valueOf(channel), "4-" + freq + "_" + duty);
    	}
    	//Log.e("test", "SendToProp after pulsed Outputs set is:" + SendToProp.toString());
    	// set output channels that are not pulsed to their appropriate state
    	int x3 = Math.abs(chsAreOutputs.size() - isOutputPulsed.size());
    	//Log.e("test", "Math.abs is:" + x3);
    	for (int i = 0; i < x3; i++) { 
    		String channel = isOutputDigital.get(i);
    		String state = digitalOutState.get(i);
    		if (state == "true") {
    			SendToProp.set(Integer.valueOf(channel), "3");
    		} else {
    			SendToProp.set(Integer.valueOf(channel), "2");
    		}
    		
    	}
    	Log.e("test", "SendToProp after insert is:" + SendToProp.toString());
    	// create string to send to prop via BT
    	int x4 = SendToProp.size();
    	//Log.e("test", "SendToProp size is:" + SendToProp.size());
    	String propMessage = "";
    	for (int i = 0; i < x4; i++) {
    		String whatIsString = SendToProp.get(i);
    		if (whatIsString.contains("4-")) {
    			String[] freqString = whatIsString.split("-");
    			String[] dutyString = freqString[1].split("_");  
    			Log.e("test", "freqString[0] is:" + freqString[0]);
    			Log.e("test", "freqString[1] is:" + freqString[1]);
    			Log.e("test", "dutyString[0] is:" + dutyString[0]);
    			Log.e("test", "dutyString[1] is:" + dutyString[1]);
    			propMessage = propMessage.concat("0" + freqString[0] + "\r" + "0" + dutyString[0] + "\r" + "0" + dutyString[1] + "\r");
    		} else {
    			propMessage = propMessage + "0" + whatIsString + "\r";
    		}
    	} 
    	Log.e("test", "propMessage after insert is:" + propMessage);
    	//((AndroiDAQTCPMain) context).sendMessage(propMessage + "\r");
    	String[] subMessages = propMessage.split("\\r"); // break message into sub-messages so data isn't lost in transmission
    	int numOfArrays = subMessages.length;
    	for (int i = 0; i < numOfArrays; i++) {
    		Log.e("test", "subMessages after insert is:" + subMessages[i]);
    		((AndroiDAQTCPMain) context).sendMessage(subMessages[i] + "\r");
    		try {
                Thread.sleep(9);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    	} 
		//TODO
    	Log.e("test", "runVolts is:" + runVolts);
    	Log.e("test", "runInputs is:" + runInputs);
    	Log.e("test", "runAll is:" + runAll);
    	if (sendOutputs) {
    		sendOutputs = false;
    		((AndroiDAQTCPMain) context).setOutputs();
    	}
    	if (runVolts) {
    		((AndroiDAQTCPMain) context).getVolts(true);
    		runVolts=false;
    	}
    	if (runInputs) {
    		((AndroiDAQTCPMain) context).getInputs(true);
    		runInputs = false;
    	}
    	if (runContInputs) {
    		((AndroiDAQTCPMain) context).getInputsCont(true);
    		// TODO runInputs = false;
    	}
    	if (runAll) {
    		((AndroiDAQTCPMain) context).setOutputs();
    		try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    		((AndroiDAQTCPMain) context).getAll(true);
    	}
	}
	public void stopContInput() {
		((AndroiDAQTCPMain) context).stopContInput();
	}
    @Override
    public void destroyItem( View pager, int position, Object view )
    {
        ((ViewPager)pager).removeView( (View)view );
    }
 
    @Override
    public boolean isViewFromObject( View view, Object object )
    {
        return view.equals( object );
    }
 
    @Override
    public void finishUpdate( View view ) {}
 
    @Override
    public void restoreState( Parcelable p, ClassLoader c ) { 
    	//Log.e("Test", "restoreState");
    	if ( p instanceof SaveStates )
        {
    		isOutputCh = ( (SaveStates) p ).getisOutputCh();
    		//readVoltage = ((SaveStates) p).getreadVoltage();
    		isDigCh = ((SaveStates) p).getisDigCh();
    		outputState = ((SaveStates) p).getoutputState();
    		desiredFreq = ((SaveStates) p).getdesiredFreq();
    		desiredDuty = ((SaveStates) p).getdesiredDuty();
        }
    }
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
    @Override
    public Parcelable saveState() {
    	
    	boolean[] isInput = {
    			isOutputCh0, 
    			isOutputCh1, 
    			isOutputCh2, 
    			isOutputCh3, 
    			isOutputCh4,
    			isOutputCh5, 
    			isOutputCh6, 
    			isOutputCh7, 
    			isOutputCh8,
    			isOutputCh9, 
    			isOutputCh10, 
    			isOutputCh11, 
    			isOutputCh12,
    			isOutputCh13, 
    			isOutputCh14, 
    			isOutputCh15};
 
    	boolean[] isDig = {
    			isDigCh0,
    			isDigCh1,
    			isDigCh2,
    			isDigCh3,
    			isDigCh4,
    			isDigCh5,
    			isDigCh6,
    			isDigCh7,
    			isDigCh8,
    			isDigCh9,
    			isDigCh10,
    			isDigCh11,
    			isDigCh12,
    			isDigCh13,
    			isDigCh14,
    			isDigCh15};
    		boolean[] outputState = {
    			out_hiLow0.isChecked(), 
    			out_hiLow1.isChecked(), 
    			out_hiLow2.isChecked(), 
    			out_hiLow3.isChecked(), 
    			out_hiLow4.isChecked(), 
    			out_hiLow5.isChecked(), 
    			out_hiLow6.isChecked(), 
    			out_hiLow7.isChecked(),  
    			out_hiLow8.isChecked(), 
    			out_hiLow9.isChecked(),  
    			out_hiLow10.isChecked(),  
    			out_hiLow11.isChecked(), 
    			out_hiLow12.isChecked(), 
    			out_hiLow13.isChecked(),  
    			out_hiLow14.isChecked(), 
    			out_hiLow15.isChecked()};

    		String[] desiredFreq = {
    			allFreqOut0.getText().toString(), 
    			allFreqOut1.getText().toString(), 
    			allFreqOut2.getText().toString(), 
    			allFreqOut3.getText().toString(), 
    			allFreqOut4.getText().toString(), 
    			allFreqOut5.getText().toString(), 
    			allFreqOut6.getText().toString(), 
    			allFreqOut7.getText().toString(), 
    			allFreqOut8.getText().toString(), 
    			allFreqOut9.getText().toString(), 
    			allFreqOut10.getText().toString(), 
    			allFreqOut11.getText().toString(), 
    			allFreqOut12.getText().toString(), 
    			allFreqOut13.getText().toString(), 
    			allFreqOut14.getText().toString(), 
    			allFreqOut15.getText().toString(), };

    		String[] desiredDuty = {
    			allDutyOut0.getText().toString(), 
    			allDutyOut1.getText().toString(), 
    			allDutyOut2.getText().toString(), 
    			allDutyOut3.getText().toString(), 
    			allDutyOut4.getText().toString(), 
    			allDutyOut5.getText().toString(), 
    			allDutyOut6.getText().toString(), 
    			allDutyOut7.getText().toString(), 
    			allDutyOut8.getText().toString(), 
    			allDutyOut9.getText().toString(), 
    			allDutyOut10.getText().toString(), 
    			allDutyOut11.getText().toString(), 
    			allDutyOut12.getText().toString(), 
    			allDutyOut13.getText().toString(), 
    			allDutyOut14.getText().toString(), 
    			allDutyOut15.getText().toString(), };

    	//Log.e("Test", "saveState desiredFreq is: " + isDig[0]);
    	//return new SaveStates( isInput, readVoltage, isDig, outputState, desiredFreq );
    	return new SaveStates( isInput, isDig, outputState, desiredFreq, desiredDuty);
    }
    public Bundle getUIStates() {
    	boolean[] isInput = {
    			isOutputCh0, 
    			isOutputCh1, 
    			isOutputCh2, 
    			isOutputCh3, 
    			isOutputCh4,
    			isOutputCh5, 
    			isOutputCh6, 
    			isOutputCh7, 
    			isOutputCh8,
    			isOutputCh9, 
    			isOutputCh10, 
    			isOutputCh11, 
    			isOutputCh12,
    			isOutputCh13, 
    			isOutputCh14, 
    			isOutputCh15};
 
    	boolean[] isDig = {
    			isDigCh0,
    			isDigCh1,
    			isDigCh2,
    			isDigCh3,
    			isDigCh4,
    			isDigCh5,
    			isDigCh6,
    			isDigCh7,
    			isDigCh8,
    			isDigCh9,
    			isDigCh10,
    			isDigCh11,
    			isDigCh12,
    			isDigCh13,
    			isDigCh14,
    			isDigCh15};
    	
    		boolean[] outputState = {
    			out_hiLow0.isChecked(), 
    			out_hiLow1.isChecked(), 
    			out_hiLow2.isChecked(), 
    			out_hiLow3.isChecked(), 
    			out_hiLow4.isChecked(), 
    			out_hiLow5.isChecked(), 
    			out_hiLow6.isChecked(), 
    			out_hiLow7.isChecked(),  
    			out_hiLow8.isChecked(), 
    			out_hiLow9.isChecked(),  
    			out_hiLow10.isChecked(),  
    			out_hiLow11.isChecked(), 
    			out_hiLow12.isChecked(), 
    			out_hiLow13.isChecked(),  
    			out_hiLow14.isChecked(), 
    			out_hiLow15.isChecked()};
    		
      		String[] desiredFreq = { 
    			allFreqOut0.getText().toString(), 
    			allFreqOut1.getText().toString(), 
    			allFreqOut2.getText().toString(), 
    			allFreqOut3.getText().toString(), 
    			allFreqOut4.getText().toString(), 
    			allFreqOut5.getText().toString(), 
    			allFreqOut6.getText().toString(), 
    			allFreqOut7.getText().toString(), 
    			allFreqOut8.getText().toString(), 
    			allFreqOut9.getText().toString(), 
    			allFreqOut10.getText().toString(), 
    			allFreqOut11.getText().toString(), 
    			allFreqOut12.getText().toString(), 
    			allFreqOut13.getText().toString(), 
    			allFreqOut14.getText().toString(), 
    			allFreqOut15.getText().toString(), };
      		
      		String[] desiredDuty = { 
        			allDutyOut0.getText().toString(), 
        			allDutyOut1.getText().toString(), 
        			allDutyOut2.getText().toString(), 
        			allDutyOut3.getText().toString(), 
        			allDutyOut4.getText().toString(), 
        			allDutyOut5.getText().toString(), 
        			allDutyOut6.getText().toString(), 
        			allDutyOut7.getText().toString(), 
        			allDutyOut8.getText().toString(), 
        			allDutyOut9.getText().toString(), 
        			allDutyOut10.getText().toString(), 
        			allDutyOut11.getText().toString(), 
        			allDutyOut12.getText().toString(), 
        			allDutyOut13.getText().toString(), 
        			allDutyOut14.getText().toString(), 
        			allDutyOut15.getText().toString(), };
      		
     	for (String freq: desiredFreq) {
    		//Log.e("test", "saving these freqs:" + freq);
    	}
     	for (String duty: desiredDuty) {
    		//Log.e("test", "saving these dutys:" + duty);
    	}
     	
    	Bundle myBundle = new Bundle();
    	myBundle.putBooleanArray("isInput", isInput);
    	myBundle.putBooleanArray("isDig", isDig);
    	myBundle.putBooleanArray("outputState", outputState);
    	myBundle.putStringArray("desiredFreqs", desiredFreq);
    	myBundle.putStringArray("desiredDutys", desiredDuty);
    	return myBundle;
    }
    public void setUIStates(Bundle bundle) {

    	isOutputCh = bundle.getBooleanArray("isInput");
		isDigCh = bundle.getBooleanArray("isDig");
		outputState = bundle.getBooleanArray("outputState");
		desiredFreq = bundle.getStringArray("desiredFreqs");
		desiredDuty = bundle.getStringArray("desiredDutys");
    }
    @Override
    public void startUpdate( View view ) {}
    
	/* @Override
	public void onScrollChanged(ObservableScrollView scrollView, int x, int y,
			int oldx, int oldy) {
	    View view = (View) scrollView.getChildAt(scrollView.getChildCount() - 1);
	    int diff = (view.getBottom() - (scrollView.getHeight() + scrollView.getScrollY()));

	    // if diff is zero, then the bottom has been reached
	    if (diff == 0) {
	    	 ((AndroiDAQTCPMain)context).openMenu();
	    }
	} */

}