clc
clear all
close all

%% input
A=[0,0,0,0,0;0,1,1,1,0;0,0,0,0,0]; % 0=tomato 1=mushroom
size=size(A);
R=size(1); % rows
C=size(2); % columns
L=1;
H=6;
no_M=sum(A(:)==1); % number of mushrooms
no_T=sum(A(:)==0); % number of tomatoes

%% slice characterization
min_no_slices=0; % minimum number of slices
dec_min_slices=R*C/H; % decimal minimum number of slices
if min([no_M,no_T]) < dec_min_slices
    min_no_slices=min([no_M,no_T]);
elseif rem(R*C,H) >= 2*L % remainder
    min_no_slices=ceil(dec_min_slices);
else % if rem(R*C,H) < 2*L
    min_no_slices=floor(dec_min_slices);
end

% max_divisor is the maximum length of the longest side of a bidimensional slice
divH=divisors(H);
max_divisor=divH(length(divH)-1); % maximum divisor of H excluding H itself

% are monodimensional slices of area H possible?
max_area_monodim_slice=true;
if H > max([R,C])
    max_area_monodim_slice=false;
end

% are square slices of area H possible?
max_area_square_slice=false;
if sqrt(H)==floor(sqrt(H)) % if H is a perfect square
    max_area_square_slice=true;
end

% are slices of area H possible?
max_area_slice=true;
if rem(H,2)~=0 && ~max_area_monodim_slice && ~max_area_square_slice
    max_area_slice=false;
end

%% computation (abbozzo)
slices=0;
counter=0;
M_found=false;
if no_T > no_M
    while slices < min_no_slices
        for j=1:C
            for i=1:R
                if A(i,j)==1 && A(i,j)==1
                    A=A';
                end
                if A(i,j)==1 
                    M_found=true;
                end
            end
        end
    end
else
    while slices < min_no_slices
    
    end
end