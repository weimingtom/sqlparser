// $ANTLR 2.7.7 (2006-11-01): "src/parser/oracle/parser_oracle.g" -> "Oracle9iLexer.java"$

	package parser.oracle;

public interface Oracle9iParserTokenTypes {
	int EOF = 1;
	int NULL_TREE_LOOKAHEAD = 3;
	int SELECT_STATEMENT = 4;
	int SEARCH_NOT_CONDITION = 5;
	int SUBQUERY = 6;
	int GROUP_BY = 7;
	int ORDER_BY = 8;
	int ALIAS_EQU = 9;
	int FUNCTION = 10;
	int FUNCTION_NOTHING = 11;
	int FUNCTION_EMPTY_PARAM = 12;
	int FUNCTION_STAR_PARAM = 13;
	int FUNCTION_STAR_COUNT = 14;
	int FUNCTION_DATA_TYPE = 15;
	int FUNCTION_AS_DATA_TYPE = 16;
	int LOGIC_OP = 17;
	int LOGICAL_NULL = 18;
	int LOGICAL_NOT_NULL = 19;
	int LOGICAL_IN = 20;
	int LOGICAL_NOT_IN = 21;
	int LOGICAL_LIKE = 22;
	int LOGICAL_NOT_LIKE = 23;
	int LOGICAL_EXISTS = 24;
	int LOGICAL_NOT_EXISTS = 25;
	int LOGICAL_BETWEEN = 26;
	int SUBCONTAIN_OP = 27;
	int ALL_FIELDS = 28;
	int PAREN_FIELD = 29;
	int PAREN_DATA_TYPE = 30;
	int PAREN_CHAR_DATA_TYPE = 31;
	int LOGIC_BLOCK = 32;
	int ROWNUM_BLOCK = 33;
	int COLUMN = 34;
	int WHERE = 35;
	int SEMI = 36;
	int TABLE_UNION_EN = 37;
	int TABLE_UNION_CN = 38;
	int COMMA = 39;
	int TABLE_COMPARE_EN = 40;
	int TABLE_COMPARE_CN = 41;
	int WHERE_EN = 42;
	int WHERE_CN = 43;
	int EXISTS_EN = 44;
	int EXISTS_CN = 45;
	int NOT_EXISTS_CN = 46;
	int NOT_EN = 47;
	int SELECT_EN = 48;
	int SELECT_CN = 49;
	int DISTINCT_EN = 50;
	int DISTINCT_CN = 51;
	int FROM_EN = 52;
	int FROM_CN = 53;
	int GROUP_EN = 54;
	int BY_EN = 55;
	int GROUP_BY_CN = 56;
	int ORDER_EN = 57;
	int ORDER_BY_CN = 58;
	int NOT_CN = 59;
	int AND_EN = 60;
	int OR_EN = 61;
	int AND_CN = 62;
	int OR_CN = 63;
	int LPAREN = 64;
	int RPAREN = 65;
	int AS_EN = 66;
	int AS_CN = 67;
	// "=" = 68
	// "\u7b49\u4e8e" = 69
	int SELECT_ALL_CN = 70;
	int STAR = 71;
	int ASC_EN = 72;
	int ASC_CN = 73;
	int DESC_EN = 74;
	int DESC_CN = 75;
	int LIKE_EN = 76;
	int LIKE_CN = 77;
	int NOT_LIKE_CN = 78;
	int IS_EN = 79;
	int NULL_EN = 80;
	int NULL_CN = 81;
	int NOT_NULL_CN = 82;
	int BETWEEN_CN = 83;
	int BETWEEN_EN = 84;
	int IN_EN = 85;
	int IN_CN = 86;
	int NOT_IN_CN = 87;
	int ROWNUM_EN = 88;
	int ROWNUM_CN = 89;
	int REAL_NUM = 90;
	int COUNT_EN = 91;
	int COUNT_CN = 92;
	int ALL_EN = 93;
	int ALL_CN = 94;
	int DATA_TYPE_AS_CN = 95;
	int CHAR = 96;
	int DATA_TYPE_STRING = 97;
	int ID = 98;
	int PARAM_ID = 99;
	int QUOTED_STRING = 100;
	int POINT = 101;
	int NEGATIVE_DIGIT_ELEMENT = 102;
	int LITERAL_avg = 103;
	// "\u6c42\u5e73\u5747\u6570" = 104
	int LITERAL_max = 105;
	// "\u6c42\u6700\u5927\u503c" = 106
	int LITERAL_min = 107;
	// "\u6c42\u6700\u5c0f\u503c" = 108
	int LITERAL_stddev = 109;
	// "\u6c42\u6807\u51c6\u5dee" = 110
	int LITERAL_sum = 111;
	// "\u6c42\u603b\u548c" = 112
	int LITERAL_variance = 113;
	// "\u6c42\u534f\u65b9\u5dee" = 114
	int SYSDATE_EN = 115;
	int SYSDATE_CN = 116;
	int LITERAL_cast = 117;
	// "\u6570\u636e\u7c7b\u578b\u8f6c\u5316" = 118
	int LITERAL_abs = 119;
	// "\u53d6\u7edd\u5bf9\u503c" = 120
	int LITERAL_acos = 121;
	// "\u6c42\u53cd\u4f59\u5f26\u503c" = 122
	int LITERAL_asin = 123;
	// "\u6c42\u53cd\u6b63\u5f26\u503c" = 124
	int LITERAL_atan = 125;
	// "\u6c42\u53cd\u6b63\u5207\u503c" = 126
	// "atin2" = 127
	// "\u6c42\u4e8c\u4e2a\u6570\u7684\u53cd\u6b63\u5207\u503c" = 128
	int LITERAL_ceil = 129;
	// "\u53d6\u4e0a\u9650\u6574\u6570" = 130
	int LITERAL_cos = 131;
	// "\u6c42\u4f59\u5f26\u503c" = 132
	int LITERAL_cosh = 133;
	// "\u6c42\u4f59\u5207\u503c" = 134
	int LITERAL_exp = 135;
	// "\u6c42\u5e42\u503c" = 136
	int LITERAL_floor = 137;
	// "\u53d6\u4e0b\u9650\u6574\u6570" = 138
	int LITERAL_ln = 139;
	// "\u6c42\u81ea\u7136\u5bf9\u6570" = 140
	int LITERAL_log = 141;
	// "\u6c42\u5bf9\u6570" = 142
	int LITERAL_mod = 143;
	// "\u6c42\u6a21" = 144
	int LITERAL_power = 145;
	// "\u6c42\u5e42" = 146
	int LITERAL_round = 147;
	// "\u683c\u5f0f\u5316\u6570\u503c" = 148
	int LITERAL_sign = 149;
	// "\u6c42\u503c\u7684\u7b26\u53f7" = 150
	int LITERAL_sin = 151;
	// "\u6c42\u6b63\u5f26\u503c" = 152
	int LITERAL_sinh = 153;
	// "\u6c42\u53cc\u66f2\u6b63\u5f26\u503c" = 154
	int LITERAL_sqrt = 155;
	// "\u6c42\u5e73\u65b9\u6839" = 156
	int LITERAL_tan = 157;
	// "\u6c42\u6b63\u5207\u503c" = 158
	int LITERAL_tanh = 159;
	// "\u6c42\u53cc\u66f2\u6b63\u5207\u503c" = 160
	int LITERAL_trunc = 161;
	// "\u683c\u5f0f\u5316\u6570\u503c2" = 162
	int LITERAL_ascii = 163;
	// "\u6c42ASCII\u7801" = 164
	int LITERAL_asciistr = 165;
	// "\u6c42\u5b57\u7b26\u4e32ASCII\u7801" = 166
	int LITERAL_chr = 167;
	// "\u6c42\u7b49\u503c\u7684\u5b57\u7b26" = 168
	int LITERAL_concat = 169;
	// "\u5b57\u7b26\u4e32\u8fde\u63a5" = 170
	int LITERAL_initcap = 171;
	// "\u5355\u8bcd\u9996\u5b57\u6bcd\u5927\u51991" = 172
	int LITERAL_instr = 173;
	// "\u6c42\u4e32\u4f4d\u7f6e" = 174
	int LITERAL_length = 175;
	// "\u6c42\u5b57\u7b26\u4e32\u957f\u5ea6" = 176
	int LITERAL_lower = 177;
	// "\u8f6c\u4e3a\u5c0f\u5199\u5b57\u6bcd1" = 178
	int LITERAL_ltrim = 179;
	// "\u53bb\u6389\u5de6\u7a7a\u683c" = 180
	int LITERAL_lpad = 181;
	// "\u5b57\u7b26\u4e32\u5de6\u8865" = 182
	int LITERAL_nls_initcap = 183;
	// "\u5355\u8bcd\u9996\u5b57\u6bcd\u5927\u51992" = 184
	int LITERAL_nls_lower = 185;
	// "\u8f6c\u4e3a\u5c0f\u5199\u5b57\u6bcd2" = 186
	int LITERAL_nlssort = 187;
	// "\u5b57\u7b26\u4e32\u6392\u5e8f" = 188
	int LITERAL_nls_upper = 189;
	// "\u8f6c\u4e3a\u5927\u5199\u5b57\u6bcd2" = 190
	int LITERAL_replace = 191;
	// "\u5b57\u7b26\u4e32\u66ff\u6362" = 192
	int LITERAL_rpad = 193;
	// "\u5b57\u7b26\u4e32\u53f3\u8865" = 194
	int LITERAL_rtrim = 195;
	// "\u53bb\u6389\u53f3\u7a7a\u683c" = 196
	int LITERAL_soundex = 197;
	// "\u6c42\u5b57\u7b26\u4e32\u58f0\u97f3\u503c" = 198
	int LITERAL_substr = 199;
	// "\u5b57\u7b26\u4e32\u622a\u53d6" = 200
	int LITERAL_trim = 201;
	// "\u53bb\u5de6\u53f3\u7a7a\u683c" = 202
	int LITERAL_translate = 203;
	// "\u5b57\u7b26\u4e32\u5168\u66ff\u6362" = 204
	int LITERAL_upper = 205;
	// "\u8f6c\u4e3a\u5927\u5199\u5b57\u6bcd1" = 206
	int LITERAL_add_months = 207;
	// "\u6708\u4efd\u8fd0\u7b97" = 208
	int LITERAL_last_day = 209;
	// "\u6c42\u65e5\u671f\u6700\u540e\u4e00\u5929" = 210
	int LITERAL_months_between = 211;
	// "\u6c42\u6708\u4efd\u5dee\u503c" = 212
	int LITERAL_new_time = 213;
	// "\u6c42\u5bf9\u5e94\u65f6\u533a\u7684\u65f6\u95f4" = 214
	int LITERAL_next_day = 215;
	// "\u6c42\u5177\u4f53\u661f\u671f\u7684\u65e5\u671f" = 216
	int LITERAL_bin_to_num = 217;
	// "\u4e8c\u8fdb\u5236\u8f6c\u4e3a\u6570\u503c" = 218
	int LITERAL_chartorowid = 219;
	// "\u5b57\u7b26\u4e32\u8f6c\u4e3a\u884c\u53f7" = 220
	int LITERAL_convert = 221;
	// "\u5b57\u7b26\u4e32\u8f6c\u5316" = 222
	int LITERAL_hextoraw = 223;
	// "\u5341\u516d\u8fdb\u5236\u8f6c\u4e3a\u4e8c\u8fdb\u5236" = 224
	int LITERAL_rawtohex = 225;
	// "\u4e8c\u8fdb\u5236\u8f6c\u4e3a\u5341\u516d\u8fdb\u5236" = 226
	int LITERAL_rowidtochar = 227;
	// "\u884c\u53f7\u8f6c\u6210\u5b57\u7b26\u4e32" = 228
	int LITERAL_to_char = 229;
	// "\u8f6c\u4e3a\u5b57\u7b26\u578b" = 230
	int LITERAL_to_date = 231;
	// "\u8f6c\u4e3a\u65e5\u671f\u578b" = 232
	int LITERAL_to_multi_byte = 233;
	// "\u8f6c\u4e3a\u591a\u5b57\u8282\u578b" = 234
	int LITERAL_to_number = 235;
	// "\u8f6c\u4e3a\u6570\u503c\u578b" = 236
	int LITERAL_to_single_byte = 237;
	// "\u8f6c\u4e3a\u5355\u5b57\u8282\u578b" = 238
	int LITERAL_uid = 239;
	// "\u6c42\u6807\u8bc6\u7f16\u53f7" = 240
	int LITERAL_user = 241;
	// "\u6c42\u5f53\u524d\u7528\u6237" = 242
	int LITERAL_userenv = 243;
	// "\u6c42\u5f53\u524d\u7528\u6237\u73af\u5883\u4fe1\u606f" = 244
	int LITERAL_vsize = 245;
	// "\u6c42\u5b57\u6bb5\u5927\u5c0f" = 246
	int LITERAL_decode = 247;
	// "\u6c42\u6bd4\u8f83\u7ed3\u679c" = 248
	int LITERAL_dump = 249;
	// "\u8fd4\u56de\u6570\u636e\u683c\u5f0f" = 250
	int LITERAL_empty_blob = 251;
	// "\u521d\u59cb\u5316BLOB" = 252
	int LITERAL_empty_clob = 253;
	// "\u521d\u59cb\u5316CLOB" = 254
	int LITERAL_greatest = 255;
	// "\u6c42\u6700\u5927\u8868\u8fbe\u5f0f" = 256
	int LITERAL_least = 257;
	// "\u6c42\u6700\u5c0f\u8868\u8fbe\u5f0f" = 258
	int LITERAL_nvl = 259;
	// "\u6c42\u975e\u7a7a\u503c" = 260
	int TILDE = 261;
	// "\u975e\u8fd0\u7b97" = 262
	// "\u4e0e" = 263
	// "\u6216" = 264
	// "\u5f02\u6216" = 265
	// "\u52a0" = 266
	// "\u51cf" = 267
	// "\u4e58" = 268
	// "\u9664" = 269
	int PLUS = 270;
	int MINUS = 271;
	int DIVIDE = 272;
	int MOD = 273;
	int AMPERSAND = 274;
	int BITWISEOR = 275;
	int BITWISEXOR = 276;
	int ASSIGNEQUAL = 277;
	// "\u5927\u4e8e\u7b49\u4e8e" = 278
	// "\u5c0f\u4e8e\u7b49\u4e8e" = 279
	// "\u5927\u4e8e" = 280
	// "\u5c0f\u4e8e" = 281
	// "\u4e0d\u7b49\u4e8e" = 282
	int NOTEQUAL1 = 283;
	int NOTEQUAL2 = 284;
	int LESSTHANOREQUALTO1 = 285;
	int LESSTHANOREQUALTO2 = 286;
	int LESSTHAN = 287;
	int GREATERTHANOREQUALTO1 = 288;
	int GREATERTHANOREQUALTO2 = 289;
	int GREATERTHAN = 290;
	int LITERAL_year = 291;
	int LITERAL_yy = 292;
	int LITERAL_yyyy = 293;
	int LITERAL_month = 294;
	int LITERAL_mm = 295;
	int LITERAL_m = 296;
	int LITERAL_day = 297;
	int LITERAL_dd = 298;
	int LITERAL_d = 299;
	int LITERAL_quarter = 300;
	int LITERAL_qq = 301;
	int LITERAL_q = 302;
	int LITERAL_week = 303;
	int LITERAL_wk = 304;
	int LITERAL_w = 305;
	int LITERAL_dayofyear = 306;
	int LITERAL_dy = 307;
	int LITERAL_y = 308;
	int LITERAL_weekday = 309;
	int LITERAL_dw = 310;
	int LITERAL_hour = 311;
	int LITERAL_hh = 312;
	// "hh12" = 313
	// "hh24" = 314
	int LITERAL_minute = 315;
	int LITERAL_mi = 316;
	int LITERAL_n = 317;
	int LITERAL_second = 318;
	int LITERAL_ss = 319;
	int LITERAL_s = 320;
	int LITERAL_millisecond = 321;
	int LITERAL_ms = 322;
	int LITERAL_long = 323;
	int LITERAL_date = 324;
	int LITERAL_rowid = 325;
	int LITERAL_clob = 326;
	int LITERAL_nclob = 327;
	int LITERAL_blob = 328;
	int LITERAL_bfile = 329;
	int DOT_STAR = 330;
	int LEFT_JOIN = 331;
	int PARAM_LPAREN = 332;
	int PARAM_RPAREN = 333;
	int FROM = 334;
	int WS = 335;
	int ESC = 336;
	int ID_START_LETTER = 337;
	int ID_LETTER = 338;
	int NUM = 339;
	int DOT_NUM = 340;
	int NUM_START = 341;
	int NUM_LETTER = 342;
	int ML_COMMENT = 343;
	int COMPARE_OP = 344;
	int TWO_ARG_OP = 345;
	int ONE_ARG_OP = 346;
	// "\u5de6\u8fde\u63a5" = 347
	// "\u6c42\u5b57\u7b26\u4e32\u6700\u5927\u503c" = 348
	// "\u6c42\u5b57\u7b26\u4e32\u6700\u5c0f\u503c" = 349
}